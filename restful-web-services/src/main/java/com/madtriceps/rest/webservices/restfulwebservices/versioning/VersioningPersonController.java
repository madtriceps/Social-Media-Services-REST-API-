package com.madtriceps.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

//	Versioning can be done by 3 methods:------

//	 Method-1: BY URL method: create diff URLS for same content depending on version
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

//   Method 2-: By parameter passing in the Query Parameter
	@GetMapping(path = "/person", params = "version=1")
	public PersonV1 getFirstVersionOfPersonRequestParameter() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping(path = "/person", params = "version=2")
	public PersonV2 getSecondVersionOfPersonParameter() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

//   Method-3:By Headers. Send info of which version u wish to see via headers
	@GetMapping(path = "/person/headerMethod", headers = "X-API-VERSION=1")
	public PersonV1 getFirstVersionOfPersonRequestHeader() {
		return new PersonV1("Bob Charlie");

	}

	@GetMapping(path = "/person/headerMethod", headers = "X-API-VERSION=2")
	public PersonV2 getSecondVersionOfPersonHeader() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	
//	 Method-4: Accept Header Versioning
	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
	public PersonV1 getFirstVersionOfPersonRequestAcceptHeader() {
		return new PersonV1("Bob Charlie");

	}
	

	@GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
	public PersonV2 getSecondVersionOfPersonAcceptHeader() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

}
