# Android
Collection of my own android apps

First I downloaded Android Studio on my computer
(I'm using this tutorial)
https://developer.android.com/training/basics/firstapp/creating-project

1.) cd /Applications/android-studio/studio.h
2.) Create a new project and select No Activity (Easiest imo is to just copy another project and change the name)
3.) I did Android Q as the OS since it's Android 10 and my phone runs Android 11. I figured it'd be compatible
4.) I used the Language Java rather Kotlin.
5.) The first time this booted up took forever
6.) Creating a virtual object didn't work real well
cannot add library /home/carlos/Android/Sdk/emulator/qemu/linux-x86_64/lib64/vulkan/libvulkan.so: failed 
2022-05-18 22:58:43,145 [ 402644]  ERROR -       Emulator: Pixel 2 API 30 - Failed to create Vulkan instance.
7.) But a physical object via wireless worked but not with a hard line.
8.) Just make sure to get developer mode on your phone set up and enable wireless debugging. Then pair your phone using the QR code
by clicking Pair Using Wi-Fi
9.) The wireless method was fine because I can easily send my program over wifi and install it on there.
10.) The two main areas you want to edit code are here:
app/java/com.example.*/MainActivity -> for code
app/res/layout/activity_main.xml -> for the layout
app/res/values/strings.xml -> for external strings. Make sure to use the editor if you don't want to code. I find coding a bit easier honestly.


COPYING ANOTHER PROJECT

1.) First change the folder name
2.) Open a text editor and edit the following files to reflect the name of the new app
BUT. MAKE SURE TO EDIT THESE FILES WITHIN ANDROID STUDIO
~/settings.gradle
~/app/build.gradle
~/app/src/androidTest/java/com/example/
~/app/src/androidTest/java/com/example/*/ExampleInstrumentedTest.java
~/app/src/main/AndroidManifest.xml
~/app/src/main/java/com/example/
~/app/src/main/java/com/example/*/MainActivity.java
~/app/src/main/res/values-night/themes.xml
~/app/src/main/res/values/strings.xml
~/app/src/main/res/values/themes.xml
~/app/src/test/java/com/example/
~/app/src/test/java/com/example/*/ExampleUnitTest.java


