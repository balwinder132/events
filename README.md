Follow below steps to run:

1. Make sure you have Java 8 installed and environment variables set for it. If you don't know how to set Environment Variables follow steps in link 
https://confluence.atlassian.com/doc/setting-the-java_home-variable-in-windows-8895.html

2. Download latest version of Maven and unzip it. Make sure to set Environment Variables for maven to get mvn working. Check the link to know more
https://www.mkyong.com/maven/how-to-install-maven-in-windows/

3. Install Tortoise git https://tortoisegit.org/download/

4. Install Mysql and create DB named as 'events'

4. Go to any folder in your computer and clone repo.
  
    git clone https://github.com/balwinder132/events.git

5. Open CMD and Go to root folder i.e. 'events' and run below commands

      $ mvn clean install
      
     It will take some time, Once it says 'Build Successful" run below command
     
     $ mvn spring-boot:run
  
    Open browser and visit http://localhost:8080 
