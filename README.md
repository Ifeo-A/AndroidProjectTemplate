# Android single module template

## Screenshots

![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)

## Usage/Examples

Run the following commands to use.

1. Clone this single_module_template branch <br>

```
git clone https://github.com/Ifeo-A/AndroidProjectTemplate.git --branch single_module_template
```

2. Change directory into `AndroidProjectTemplate` and run the customizer script <br>

Where <br>
**[YOUR_PLATFORM_NAME]**: can be one of the following. **`macIntelDist`** *(Intel Mac)*, or **`macM1Dist`** *(M1 Mac)* <br>

**[DOT_NOTATION_PACKAGE_NAME]**: is your package name e.g `com.my.androidapp` using dot notation <br>

**[APPLICATION_NAME]**: is your **OPTIONAL** application name e.g `MyMoistApp`

```
project_customizer/[YOUR_PLATFORM_NAME]/main/main -p [DOT_NOTATION_PACKAGE_NAME] -a [APPLICATION_NAME]
```
**or**
```
project_customizer/[YOUR_PLATFORM_NAME]/main/main --packageName [DOT_NOTATION_PACKAGE_NAME] -appName [APPLICATION_NAME]
```

<br>

## Example command <br>
```
project_customizer/macIntelDist/main/main --packageName com.two.three -appName MoistApp
```

<br>
You're good to go now.

## Features



