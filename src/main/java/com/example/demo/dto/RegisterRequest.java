] COMPILATION ERROR : 
[INFO] -------------------------------------------------------------
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/AuthController.java:[30,30] cannot find symbol
  symbol:   method getRole()
  location: variable request of type com.example.demo.dto.RegisterRequest
[INFO] 1 error
[INFO] -------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  20.081 s
[INFO] Finished at: 2025-12-22T09:56:32Z
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.11.0:compile (default-compile) on project demo2: Compilation failure
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/AuthController.java:[30,30] cannot find symbol
[ERROR]   symbol:   method getRole()
[ERROR]   location: variable request of type com.example.demo.dto.RegisterRequest
[ERROR] 
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException