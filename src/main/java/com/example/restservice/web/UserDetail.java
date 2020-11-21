//package com.example.restservice.web;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.example.restservice.domain.User;
//import com.example.restservice.domain.UserRepo;
//
//@Service
//public class UserDetail implements UserDetailsService {
//	private final UserRepo repo;
//
//	@Autowired
//	public UserDetail(UserRepo userrepo) {
//		this.repo = userrepo;
//	}
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User curruser = repo.findByUsername(username);
//		UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(),
//				AuthorityUtils.createAuthorityList(curruser.getRole()));
//		return user;
//	}
//}
