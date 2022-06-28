# Chromebook OS

Alright I am using a chrome book for the first time and learning how to set it up properly. 

Before you do anything put your device in developer mode or it will reformat everything. 

WHat you want to do is turn off your computer, press ESC, REFRESH and POWER all at the same time. Then hit CTRL+D 

when random windows pop up.

In order to start power coding you're going to need a few apps.

APPs 

0. Terminal 

Enabling developer mode will allow you to use an entire linux kernel. THis is way better than Termux below and you will
have more control and it will feel just like home on Ubuntu. It's debian based and acts exactly like your computer at home.
I really really really like this chromebook.

FYI - you can run sudo apt-get updates and installs to get g++ and other programs that you normally use to run code.

1. Termux - This app will allow you to run things in terminal. The directories are a bit odd (NOte that in developer mode you can get an actual Linux Terminal)

/storage/emulated/0 is the location of all your files but you can't access it right away.

Run the command below to access storage on your chromebook

$ termux-setup-storage

Once you do that you should have some linked folders in 

/data/data/com.termux/files/home/storage/shared/

That shared folder is basically a symbolic link to /storage/emulated/0 which is now accessible by termux.

Assuming you want to pull down code you need to get git

$ pkg install git

as well as openssh

$ pkg install openssh

make sure to select the package manager's configuration file

You can then go through all the standard setup for git (init, add origin, ...). Note that in order
to use the free text app you need to put your Github repo into the Downloads folder. For whatever reason
I can only get the text app to save in that folder. So if you're reading this I hope your Android.git folder
is in the Downloads directory.

Also the only other difference is when you run the remote add origin command you will get an error saying you need to add this directory to the list of saved directories.

$ git config --global --add safe.directory /storage/emulated/0/Downloads/Github/name_of_repo
    
You can also install emacs btw with
    
$ pkg install emacs

Also, if you want to run files you need to run the chmod +x command. Unfortunately the only place where you have root access is in the /data/data/com.termux/files/home folder. Unfortunately this text app doesn't have access there.

On the contrary, the termux app doesn't have root access in the Downloads folder but you can save files with the text app. 
If you want to run the testfile that is in this directory you need to either do

$ bash testfile 

Use the above command if you're in the downloads folder

$ chmod +x testfile
$ ./testfile
    
2. Files - This app is useful for using a GUI to see where all your files are. Basically like nautilus or windows explorer

The nice thing about setting all of this up is if you use the Files app you can access the files by 
clicking the termux field which should hopefully be right below the Google Drive tab. Note that this repo though
will be in the Downloads folder. The point though is that if you ever need to do some power coding in emacs
you can move files to and fro.

In developer mode you'll get access to something called 'Linux Files' This is a symbolic link to your $HOME directory for linux. Note sure exactly where it is but it doesn't matter at the moment.

3. Text App - This app will allow you to edit files

The good news about the text app is that you can save files to the linux folder that pops up on Files.

4. AIDE - This app will allow you to make apps on your phone and chromebook. 

YOu can get the same app for your phone to test between chromebook and your phone. Pretty awesome. 
Since you can download the Android.git repo you'll be able to run apps. Remember you need developmer mode access
and permissions turned on to install programs from AIDE.

