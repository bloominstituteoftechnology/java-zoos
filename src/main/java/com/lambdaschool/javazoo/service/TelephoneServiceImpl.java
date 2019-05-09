package com.lambdaschool.javazoo.service;

import com.lambdaschool.javazoo.repository.TelephoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "studentService")
public class TelephoneServiceImpl implements TelephoneService
{
	@Autowired
	private TelephoneRepository telephonerepos;
}
