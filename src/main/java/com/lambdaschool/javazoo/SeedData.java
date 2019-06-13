package com.lambdaschool.javazoo;

import com.lambdaschool.javazoo.model.Role;
import com.lambdaschool.javazoo.model.User;
import com.lambdaschool.javazoo.model.UserRoles;
import com.lambdaschool.javazoo.repository.RoleRepository;
import com.lambdaschool.javazoo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
	RoleRepository rolerepos;
	UserRepository userrepos;

	public SeedData(RoleRepository rolerepos, UserRepository userrepos)
	{
		this.rolerepos = rolerepos;
		this.userrepos = userrepos;
	}

	@Override
	public void run(String[] args) throws Exception
	{
		Role r1 = new Role("admin");
		Role r2 = new Role("zoodata");

		ArrayList<UserRoles> admins = new ArrayList<>();
		admins.add(new UserRoles(new User(), r1));
		admins.add(new UserRoles(new User(), r2));

		ArrayList<UserRoles> users = new ArrayList<>();
		users.add(new UserRoles(new User(), r2));

		rolerepos.save(r1);
		rolerepos.save(r2);
		User u1 = new User("lappjeff", "lambda", users);

		User u2 = new User("admin", "password", admins);

		userrepos.save(u1);
		userrepos.save(u2);
	}
}
