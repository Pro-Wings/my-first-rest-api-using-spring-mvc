package com.prowings.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.prowings.entity.Person;
import com.prowings.exception.InvalidVoterException;

@Service
public class VoterService {
	
	public String doVote(Person person)
	{
		String res = null;
		if(isValidVoter(person))
			res = person.getName() + " is valid to do the Vote!!";
		else
			res = "Not allowed to vote!!";
		
		return res;
	}

	private boolean isValidVoter(Person person) {
		
		boolean result = false;
		
		if(person.getAge() >= 18)
		{
			if(person.getCountry().equalsIgnoreCase("INDIA"))
				result = true;
			else
//			throw new InvalidVoterException("country is not valid!!");
			throw new InvalidVoterException("country is not valid!!");
		}
		else
			throw new InvalidVoterException("age is not valid!!");
		
		return result;
	}

}
