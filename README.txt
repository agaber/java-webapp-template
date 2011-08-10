Getting started with Java Web Development.

1. Install Eclipse.

2. Install Maven.

3. Install Git.

4. Set up Maven with Eclipse. The very first time you'll need to run this
command so you can have maven set up your Eclipse projects for you:

  $ mvn eclipse:eclipse -Declipse.workspace=$HOME/workspace eclipse:add-maven-repo

Where $HOME/workspace is whatever your Eclipse workspace directory is. You
should only need to do that once.

5. Maven supports setting up projects from templates, but you can just copy
this directory, cd into that directory and run mvn eclipse:eclipse and you
should be able to set up your eclipse project. mvn package will create the war
file for you and mvn jetty:run will run the server for local development.
 