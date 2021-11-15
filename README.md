# wiremockIntegration
Integrate Wiremock server with spring

In this example, /apiCall is the api service and the /greeting
endpoint is the code entry point for calling the downstream api
which is the /apiCall in this example.
I use the WiremockApplicationContestInitializer to embedded wiremock to the application
I also use implementation instead of testImplementation because I need to start wiremock
in application startup.
The /reload endpoint is to trigger wiremock to reload the content of the stubs data 
 
