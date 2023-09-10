job('First_Maven_DSL_project')
{
    description("First project dsl")
    scm
    {
       git('https://github.com/gvkusuma/Tomcat_App.git',master)
    }
    triggers
    {
       scm('* * * * *')
    }
    steps
    {
       maven('clean package','pom.xml')
    }
    publishers
    {
       archiveArtifacts('**/*.war')
    }
}
