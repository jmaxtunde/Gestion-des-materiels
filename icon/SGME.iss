; Script generated by the Inno Setup Script Wizard.
; SEE THE DOCUMENTATION FOR DETAILS ON CREATING INNO SETUP SCRIPT FILES!

#define MyAppName "SGME"
#define MyAppVersion "1.0.1"
#define MyAppExeName "SGME.exe"

[Setup]
; NOTE: The value of AppId uniquely identifies this application.
; Do not use the same AppId value in installers for other applications.
; (To generate a new GUID, click Tools | Generate GUID inside the IDE.)
AppId={{BD4C648C-D452-412A-B325-6B5664BEBC8A}
AppName={#MyAppName}
AppVersion={#MyAppVersion}
;AppVerName={#MyAppName} {#MyAppVersion}
DefaultDirName={pf}\{#MyAppName}
DefaultGroupName={#MyAppName}
OutputDir=C:\Users\Senghor AKOMINON\Desktop
OutputBaseFilename=setupSGME
SetupIconFile=D:\Senghor.dos\AppJava\SGME-CARDER\icon\icon1.ico
Compression=lzma
SolidCompression=yes

[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"
Name: "french"; MessagesFile: "compiler:Languages\French.isl"

[Tasks]
Name: "desktopicon"; Description: "{cm:CreateDesktopIcon}"; GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked

[Files]
Source: "D:\Senghor.dos\AppJava\SGME-CARDER\dist\SGME.exe"; DestDir: "{app}"; Flags: ignoreversion
Source: "D:\Senghor.dos\AppJava\SGME-CARDER\build.xml"; DestDir: "{app}"; Flags: ignoreversion
Source: "D:\Senghor.dos\AppJava\SGME-CARDER\icon.jpg"; DestDir: "{app}"; Flags: ignoreversion
Source: "D:\Senghor.dos\AppJava\SGME-CARDER\icon.PNG"; DestDir: "{app}"; Flags: ignoreversion
Source: "D:\Senghor.dos\AppJava\SGME-CARDER\icon1.jpg"; DestDir: "{app}"; Flags: ignoreversion
Source: "D:\Senghor.dos\AppJava\SGME-CARDER\manifest.mf"; DestDir: "{app}"; Flags: ignoreversion
Source: "D:\Donn�es\Logi de pro\mysql-connector-java-5.1.26\*"; DestDir: "{app}"; Flags: ignoreversion recursesubdirs createallsubdirs
; NOTE: Don't use "Flags: ignoreversion" on any shared system files

[Icons]
Name: "{group}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"
Name: "{commondesktop}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"; Tasks: desktopicon

[Run]
Filename: "{app}\{#MyAppExeName}"; Description: "{cm:LaunchProgram,{#StringChange(MyAppName, "&", "&&")}}"; Flags: nowait postinstall skipifsilent

