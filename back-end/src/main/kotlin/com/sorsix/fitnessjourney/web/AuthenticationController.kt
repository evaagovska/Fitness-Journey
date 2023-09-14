package com.sorsix.fitnessjourney.web

import com.sorsix.fitnessjourney.config.JwtUtils
import com.sorsix.fitnessjourney.model.User
import com.sorsix.fitnessjourney.model.dto.UserDto
import com.sorsix.fitnessjourney.model.dtos.UserInfoDto
import com.sorsix.fitnessjourney.service.UserService
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*
import javax.servlet.http.Cookie

@RestController
@CrossOrigin(origins = ["http://localhost:4200"], allowCredentials = "true", maxAge = 3600)
@RequestMapping("/api")
class AuthenticationController(private val authenticationManager: AuthenticationManager,
                               private val userService: UserService,
                               private val jwtUtils: JwtUtils
) {

    @PostMapping("/login")
    fun authenticate( @RequestBody req: UserDto): ResponseEntity<Any> {
        val authentication: Authentication
        authentication =
            authenticationManager.authenticate(UsernamePasswordAuthenticationToken(req.username, req.password))
        SecurityContextHolder.getContext().authentication = authentication
        val userDetails: User = authentication.principal as User
        val jwtCookie = jwtUtils.generateJwtCookie(userDetails)
        val roles: List<String> =
            userDetails.authorities?.stream()?.map { obj: GrantedAuthority? -> obj!!.authority }!!.toList()
        val userInfo = UserInfoDto(
            username = userDetails.username!!, name = userDetails.name, lastname = userDetails.surname,
            role = roles, dateOfBirth = userDetails.dateOfBirth, gender=userDetails.gender)

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString()).body(userInfo)

    }

    @PostMapping("/logout")
    fun logoutUser(): ResponseEntity<Any> {
        val cookie = jwtUtils.getCleanJwtCookie()
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE,cookie.toString()).body("")
    }
}