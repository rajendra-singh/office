Dim objResult

Set objShell = WScript.CreateObject("WScript.Shell")
Set fso = CreateObject("Scripting.FileSystemObject")

Wscript.Echo "Screen Freezed"

Do While fso.FileExists(fso.BuildPath(objShell.CurrentDirectory, "v.txt"))
	objResult = objShell.sendkeys("{NUMLOCK}{NUMLOCK}")
	Wscript.sleep (20000)
Loop

Wscript.Echo "Screen Unfrezeed"