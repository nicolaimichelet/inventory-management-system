# Notater fra kundemøte


## SOA og Webservices
 - Modulært
 - Klare og standardiserte grensesnitt
 - Løs kobling
 - Send binding
 - Service discovery
 - SOAP v REST
 - HTTP som oftest i bunnen
 - Service gives capabilities from a prescribed interface
 - 
### Web
 - SOA implementasjoner: DDS, Corba, Web services
 - W3C: WSDL, SOAP, and XML:
    - Describes interface, data type, binding information, address information
    - Header: Optional, additional information
    - Body: payload

### Service discovery:
 - UUID:
  - Centralized
 - WS-Discovery:
  - Only runtime discovery
  - Decentralized, no proxy in pratice
  - local-scoped multicast using SOAP over UDP
  1. Send out probe
  2. Eval probe, respond if they match service
  - Robust
  - Always up to date because unavailable services won't respond to probes
  
 - REST:
  - Predefined operations, type: GET, POST, DELETE
  - Everything is a resource
  - Stateless
  - OpenAPI (prefered), RAML or WADL
  - Swagger for testing



### Required libraries
  - Ws discovery library


### Background
  - NATO FMN (Future mission network)
  - FMN based on AMN
  - SMC: Service Managment Control

  - linux: avahi



### Requirements:
  - Find services using ws-discovery and populate our system
  - Publish requested services, but make sure one service isn't duplicated
  - Possibly support multiple protocls other than WS-discovery
  - Everything is open source
  - Possible to do access without internet, can use electron with javascript\html\react or make a java app
