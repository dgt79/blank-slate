package com.github.dgt79.rs;

import com.github.dgt79.domain.User;
import com.github.dgt79.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.Collection;
import java.util.stream.Collectors;

@Path("/user")
public class UserRESTService {
	Logger LOG = LogManager.getLogger(UserRESTService.class.getName());

	@Inject private UserService userService;

	@Produces({"application/json"})
	@GET
	public Collection<User> getUsers(@QueryParam("count") @DefaultValue("1") final int count) {
		LOG.debug("get users...");
		return userService.getUsers().limit(count).collect(Collectors.toList());
	}
}
