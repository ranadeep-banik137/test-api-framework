# customer-onboarding-POST-api

	As the api is based on onboarding customer, along with its customer details also to be hit as a post HTTPS call

## Notes To Run Test Cases : 

+ Test Scenarios are identified in different functional aspects of the api call.
	Examples : functional validations, request validations, response validations, http status validations.
+ All above test packages are created under : 

|Package name| Package location|
|------------|-----------------|
| functionalvalidationtests | testFrame\src\test\java\com\project\api\testscenarios\functionalvalidationtests |
| requestvalidationtests | testFrame\src\test\java\com\project\api\testscenarios\requestvalidationtests |
| responsevalidationtests | testFrame\src\test\java\com\project\api\testscenarios\responsevalidationtests |
| httpstatusvalidationtests | testFrame\src\test\java\com\project\api\testscenarios\httpstatusvalidationtests |

+ A Java restassured DSL has been created as a parent framework for executing the test flow.

|DSL Jar file name| File location|
|-----------------|--------------|
| api-test-framework-model-v3.jar | testFrame\src\test\resources |



## Schemas Available : 
	
	We can assume its request and response body schema as below format: 

+ Request Schema

	 {
	  "$id": "http://example.com/example.json",
	  "type": "object",
	  "definitions": {},
	  "$schema": "http://json-schema.org/draft-07/schema#",
	  "properties": {
	    "customerDetails": {
	      "$id": "/properties/customerDetails",
	      "type": "array",
	      "items": {
	        "$id": "/properties/customerDetails/items",
	        "type": "object",
	        "properties": {
	          "personalDetails": {
	            "$id": "/properties/customerDetails/items/properties/personalDetails",
	            "type": "object",
	            "properties": {
	              "firstName": {
	                "$id": "/properties/customerDetails/items/properties/personalDetails/properties/firstName",
	                "type": "string",
	                "title": "The Firstname Schema ",
	                "default": "",
	                "examples": [
	                  "Pankaj"
	                ]
	              },
	              "lastName": {
	                "$id": "/properties/customerDetails/items/properties/personalDetails/properties/lastName",
	                "type": "string",
	                "title": "The Lastname Schema ",
	                "default": "",
	                "examples": [
	                  "Pandey"
	                ]
	              },
	              "middleName": {
	                "$id": "/properties/customerDetails/items/properties/personalDetails/properties/middleName",
	                "type": "string",
	                "title": "The Middlename Schema ",
	                "default": "",
	                "examples": [
	                  "Kumar"
	                ]
	              },
	              "email": {
	                "$id": "/properties/customerDetails/items/properties/personalDetails/properties/email",
	                "type": "string",
	                "title": "The Email Schema ",
	                "default": "",
	                "examples": [
	                  "pankaj@ABC.com"
	                ]
	              },
	              "dateOfBirth": {
	                "$id": "/properties/customerDetails/items/properties/personalDetails/properties/dateOfBirth",
	                "type": "string",
	                "title": "The Dateofbirth Schema ",
	                "default": "",
	                "examples": [
	                  "13-03-91"
	                ]
	              },
	              "gender": {
	                "$id": "/properties/customerDetails/items/properties/personalDetails/properties/gender",
	                "type": "string",
	                "title": "The Gender Schema ",
	                "default": "",
	                "examples": [
	                  "M"
	                ]
	              },
	              "contact": {
	                "$id": "/properties/customerDetails/items/properties/personalDetails/properties/contact",
	                "type": "string",
	                "title": "The Contact Schema ",
	                "default": "",
	                "examples": [
	                  "020-8029654321"
	                ]
	              }
	            }
	          },
	          "addressDetails": {
	            "$id": "/properties/customerDetails/items/properties/addressDetails",
	            "type": "object",
	            "properties": {
	              "addressLine1": {
	                "$id": "/properties/customerDetails/items/properties/addressDetails/properties/addressLine1",
	                "type": "string",
	                "title": "The Addressline1 Schema ",
	                "default": "",
	                "examples": [
	                  "Cramson Lane"
	                ]
	              },
	              "addressLine2": {
	                "$id": "/properties/customerDetails/items/properties/addressDetails/properties/addressLine2",
	                "type": "string",
	                "title": "The Addressline2 Schema ",
	                "default": "",
	                "examples": [
	                  "Story 01/2"
	                ]
	              },
	              "addressLine3": {
	                "$id": "/properties/customerDetails/items/properties/addressDetails/properties/addressLine3",
	                "type": "string",
	                "title": "The Addressline3 Schema ",
	                "default": "",
	                "examples": [
	                  ""
	                ]
	              },
	              "city": {
	                "$id": "/properties/customerDetails/items/properties/addressDetails/properties/city",
	                "type": "string",
	                "title": "The City Schema ",
	                "default": "",
	                "examples": [
	                  "Shamshing"
	                ]
	              },
	              "pinCode": {
	                "$id": "/properties/customerDetails/items/properties/addressDetails/properties/pinCode",
	                "type": "string",
	                "title": "The Pincode Schema ",
	                "default": "",
	                "examples": [
	                  "877412"
	                ]
	              }
	            }
	          },
	          "professionalDetails": {
	            "$id": "/properties/customerDetails/items/properties/professionalDetails",
	            "type": "object",
	            "properties": {
	              "company": {
	                "$id": "/properties/customerDetails/items/properties/professionalDetails/properties/company",
	                "type": "string",
	                "title": "The Company Schema ",
	                "default": "",
	                "examples": [
	                  "Scholarz"
	                ]
	              },
	              "designation": {
	                "$id": "/properties/customerDetails/items/properties/professionalDetails/properties/designation",
	                "type": "string",
	                "title": "The Designation Schema ",
	                "default": "",
	                "examples": [
	                  "SE"
	                ]
	              },
	              "companyId": {
	                "$id": "/properties/customerDetails/items/properties/professionalDetails/properties/companyId",
	                "type": "string",
	                "title": "The Companyid Schema ",
	                "default": "",
	                "examples": [
	                  "SCH-2958"
	                ]
	              },
	              "companyLocation": {
	                "$id": "/properties/customerDetails/items/properties/professionalDetails/properties/companyLocation",
	                "type": "string",
	                "title": "The Companylocation Schema ",
	                "default": "",
	                "examples": [
	                  "Siyaal"
	                ]
	              }
	            }
	          }
	        }
	      }
	    }
	  }
	}


+ Response Schema: 

	{
	  "$id": "http://example.com/example.json",
	  "type": "object",
	  "definitions": {},
	  "$schema": "http://json-schema.org/draft-07/schema#",
	  "properties": {
	    "customerOnboardingDetails": {
	      "$id": "/properties/customerOnboardingDetails",
	      "type": "array",
	      "items": {
	        "$id": "/properties/customerOnboardingDetails/items",
	        "type": "object",
	        "properties": {
	          "cutomersIdentificationNumber": {
	            "$id": "/properties/customerOnboardingDetails/items/properties/cutomersIdentificationNumber",
	            "type": "string",
	            "title": "The Cutomersidentificationnumber Schema ",
	            "default": "",
	            "examples": [
	              "XHDFBC2145"
	            ]
	          },
	          "customerOnboardingId": {
	            "$id": "/properties/customerOnboardingDetails/items/properties/customerOnboardingId",
	            "type": "string",
	            "title": "The Customeronboardingid Schema ",
	            "default": "",
	            "examples": [
	              "154315482"
	            ]
	          },
	          "customerOnboardingDate": {
	            "$id": "/properties/customerOnboardingDetails/items/properties/customerOnboardingDate",
	            "type": "string",
	            "title": "The Customeronboardingdate Schema ",
	            "default": "",
	            "examples": [
	              "21-09-2514"
	            ]
	          }
	        }
	      }
	    }
	  }
	}

