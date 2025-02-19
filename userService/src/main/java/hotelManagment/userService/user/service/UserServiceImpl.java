package hotelManagment.userService.user.service;

import hotelManagment.userService.user.Dto.request.UserRequest;
import hotelManagment.userService.user.Dto.response.UserResponse;
import hotelManagment.userService.user.entity.User;
import hotelManagment.userService.user.Dto.response.CommonResponse;
import hotelManagment.userService.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CommonResponse createUser(UserRequest userRequest) {
        try {
            // Validate required address fields
            if (userRequest.getUserPermanentAddress() == null) {
                throw new IllegalArgumentException("Permanent address is required");
            }
            if (userRequest.getUserPresentAddress() == null) {
                throw new IllegalArgumentException("Present address is required");
            }

            // Convert UserRequest to User entity using ModelMapper
            User user = modelMapper.map(userRequest, User.class);

            // Save the user entity
            User savedUser = userRepository.save(user);

            return CommonResponse.successResponse(savedUser, "User created successfully");
        } catch (IllegalArgumentException e) {
            return CommonResponse.errorResponse(400, "Validation error: " + e.getMessage());
        } catch (Exception e) {
            return CommonResponse.errorResponse(500, "An error occurred while creating the user");
        }
    }


    @Override
    public CommonResponse<UserResponse> getUserByUsername(String username) {
        Optional<User> userOpt = userRepository.findByUsername(username);

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            // Map the User entity to the UserResponse DTO
            UserResponse userResponse = modelMapper.map(user, UserResponse.class);

            return CommonResponse.successResponse(userResponse, "User retrieved successfully");
        } else {
            return CommonResponse.errorResponse(404, "User not found");
        }
    }
}
