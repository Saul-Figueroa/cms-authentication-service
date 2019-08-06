package springSecurity;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.revature.entity.User;
import com.revature.repository.UserRepository;

@Service
public class UserPrincipleDetailService implements UserDetailsService {

	private UserRepository userRepo;
	
	public UserPrincipleDetailService(UserRepository userRepository) {
		this.userRepo=userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			User user = this.userRepo.findByEmailReturnStream(username);
			UserPrincipal userPrince = new UserPrincipal(user);
			//execeptions needed
		return userPrince;
	}

}
