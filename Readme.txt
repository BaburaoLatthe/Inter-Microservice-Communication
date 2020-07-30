//		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
//		        .queryParam("msisdn", msisdn)
//		        .queryParam("email", email)
//		        .queryParam("clientVersion", clientVersion)
//		        .queryParam("clientType", clientType)
//		        .queryParam("issuerName", issuerName)
//		        .queryParam("applicationName", applicationName);
//
//		HttpEntity<?> entity = new HttpEntity<>(headers);
//
//		HttpEntity<String> response = restTemplate.exchange(
//		        builder.toUriString(), 
//		        HttpMethod.GET, 
//		        entity, 
//		        String.class);
		
		
		Reference :: https://www.baeldung.com/spring-uricomponentsbuilder 
		
		UriComponentsBuilder class helps to create UriComponents instances by providing fine-grained control over all aspects of 
		preparing a URI including construction, expansion from template variables, and encoding.