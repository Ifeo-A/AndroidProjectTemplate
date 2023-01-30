import argparse
import os
import shutil

rootDir = os.getcwd()

defaultPackageName:str = "com.ife.android_project_template"
defaultAppName:str = "AndroidProjectTemplate"
listOfTargetFolders:list = ["main", "test", "androidTest"]
tempPackagePrefix:str = "mycom"

# usage -p com.your.appname -a YourAppName (The app name is optional)
# or
# usage --packageName com.your.appname -appName YourAppName (The app name is optional)
parser = argparse.ArgumentParser(description = "")
parser.add_argument("-p", "--packageName", type=str, help="The package name in dot notation e.g com.my.project", required=True)
parser.add_argument("-a", "--appName", type=str, help="The project name e.g MyCatApp", default=defaultAppName)
args = parser.parse_args()

userDefinedPackageName:str = args.packageName.lower() # e.g one.two.three.cheese
appName = args.appName

packagePrefixTriggered:bool = False


def renamePackageNameInFiles(dotNotationPackageName:str, userDefinedProjectName:str):

    kotlin_package_name_to_search = f"package {defaultPackageName}"
    importsToSearch = f"import {defaultPackageName}"

    for root, dirs, files in os.walk(rootDir):
        for file in files:

            if file.endswith(".kt"):
                kotlinFilePath = os.path.join(root, file)

                with open(kotlinFilePath, 'r') as f:
                    file_contents = f.read()

                    if kotlin_package_name_to_search in file_contents:
                        file_contents = file_contents\
                            .replace(kotlin_package_name_to_search, f'package {dotNotationPackageName}')

                        file_contents = file_contents\
                            .replace(importsToSearch, f'import {dotNotationPackageName}')

                        print(f"Renamed package name and imports in {kotlinFilePath} with {dotNotationPackageName}")

                        with open(kotlinFilePath, 'w') as f:
                            f.write(file_contents)

            if file.endswith("myproject.config.toml"):
                projectTomlConfigFile = os.path.join(root, file)

                with open(projectTomlConfigFile, 'r') as f:
                    file_contents = f.read()

                    if defaultPackageName in file_contents:
                        file_contents = file_contents.replace(defaultPackageName, dotNotationPackageName)

                        print(f"Renamed package name in {projectTomlConfigFile} with {dotNotationPackageName}")

                        with open(projectTomlConfigFile, 'w') as f:
                            f.write(file_contents)

            if file.endswith(".kts"):
                gradleFile = os.path.join(root, file)

                with open(gradleFile, 'r') as f:
                    file_contents = f.read()

                    if defaultPackageName in file_contents:
                        file_contents = file_contents.replace(defaultPackageName, dotNotationPackageName)
                        print(f"Renamed package name in {gradleFile} with {dotNotationPackageName}")

                        with open(gradleFile, 'w') as f:
                            f.write(file_contents)

                    if defaultAppName in file_contents:
                        file_contents = file_contents.replace(defaultAppName, userDefinedProjectName)
                        print(f"Renamed project name in {gradleFile} with {userDefinedProjectName}")

                        with open(gradleFile, 'w') as f:
                            f.write(file_contents)

            if file.endswith(".xml"):
                xmlFile = os.path.join(root, file)

                with open(xmlFile, 'r') as f:
                    file_contents = f.read()

                    if defaultAppName in file_contents:
                        file_contents = file_contents.replace(defaultAppName, userDefinedProjectName)
                        print(f"Renamed app_name string in {xmlFile} with {userDefinedProjectName}")

                        with open(xmlFile, 'w') as f:
                            f.write(file_contents)

def createFreshDirectories(sourceFolder:str, destinationFolder:str, deleteComFolderFor:str):
    print(f"SourceFolder path: {sourceFolder}")
    print(f"Creating path: {destinationFolder}")

    os.makedirs(destinationFolder, exist_ok=True)
    for item in os.scandir(sourceFolder):
        s = os.path.join(sourceFolder, item.name)
        d = os.path.join(destinationFolder, item.name)
        if item.is_file():
            shutil.copy2(s, d)
        elif item.is_dir():
            shutil.copytree(s, d, ignore_dangling_symlinks=True, dirs_exist_ok=True)

    # Delete the original /com path as its not needed
    print(f"Deleting /com folder for app/src/{deleteComFolderFor}")
    com_folder = os.path.join(rootDir, f"app/src/{deleteComFolderFor}/java/com")
    if os.path.isdir(com_folder) and 'android_project_template' in os.listdir(com_folder):
        shutil.rmtree(com_folder)
        print(f"Deleting {com_folder}")

    shutil.rmtree(os.path.join(rootDir, f"app/src/{deleteComFolderFor}/java/com"))
    print(f"Deleted the com folder --> app/src/{deleteComFolderFor}/java/com")

    # Rename destination folder to remove the "mycom" prefix to change it to start with "com" instead
    if packagePrefixTriggered:
        print(f"Renaming \"{tempPackagePrefix}\" to \"com\" ")

        newPathName = destinationFolder.replace(tempPackagePrefix, "com")

        os.renames(destinationFolder, newPathName)

def feedTargetFoldersForCreation(listOfFolders:list, dotNotationPackageName:str):
    # If the user uses com to start the package name e.g com.this.that then
    # rename the first part "com" to "mycom" so the package name now looks like this: "mycom.this.that"
    # create the "mycom" folder and then later delete the original "com" folder that existed
    # before the user ran the script.

    # if the package name starts with com then replace it with a prefix and set prefix triggered flag
    if dotNotationPackageName.split(".")[0] == "com":
        global packagePrefixTriggered
        packagePrefixTriggered = True
        dotNotationPackageName = dotNotationPackageName.replace("com", tempPackagePrefix)

    for folder in listOfFolders:
        src_folder = os.path.join(rootDir, f"app/src/{folder}/java/com/ife/android_project_template")
        dst_folder = os.path.join(rootDir, f"app/src/{folder}/java/{dotNotationPackageName.replace('.', os.sep)}")
        createFreshDirectories(sourceFolder = src_folder, destinationFolder = dst_folder, deleteComFolderFor = folder)


feedTargetFoldersForCreation(
    listOfFolders = listOfTargetFolders,
    dotNotationPackageName = userDefinedPackageName
)

renamePackageNameInFiles(
    dotNotationPackageName = userDefinedPackageName,
    userDefinedProjectName = appName
)

# Delete the folder that contains this script
shutil.rmtree(os.path.join(rootDir, f"project_customizer"))
print("Deleted project_customizer folder")
