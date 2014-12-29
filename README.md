 
This is an example project containing code used in the tutorial. The project was created using Spring MVC 4 Quickstart Maven archetype:

    https://github.com/kolorobot/spring-mvc-quickstart-archetype

maven-site-plugin

<build>
      <pluginManagement>
         <plugins>
            <plugin>
               <groupId>org.apache.maven.plugins</groupId>
               <artifactId>maven-site-plugin</artifactId>
               <configuration>
                  <unzipCommand>/usr/bin/unzip -o > err.txt</unzipCommand>
               </configuration>
            </plugin>
         </plugins>
      </pluginManagement>
</build>
<distributionManagement>
  <site>
     <id>site</id>
     <name>project website</name>
     <url>scp://local.company.com/websites/project.company.com/</url>
  </site>
</distributionManagement>    



