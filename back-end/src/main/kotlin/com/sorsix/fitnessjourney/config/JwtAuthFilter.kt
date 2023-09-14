package com.sorsix.fitnessjourney.config

import com.sorsix.fitnessjourney.service.UserService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpHeaders.AUTHORIZATION
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class JwtAuthFilter(private val jwtUtils: JwtUtils,private val userDetailsService: UserService): OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        try {
            val jwtToken = jwtUtils.getJwtFromCookies(request)
            if (jwtToken != null && jwtUtils.validateJwtToken(jwtToken)) {

                val username = jwtUtils.getUserNameFromJwtToken(jwtToken)

                val userDetails: UserDetails = userDetailsService.loadUserByUsername(username)
                val authToken = UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)

                authToken.details = WebAuthenticationDetailsSource().buildDetails(request)
                SecurityContextHolder.getContext().authentication = authToken

            }
            filterChain.doFilter(request, response)
        } catch (e: Exception) {
            Companion.logger.error(e.message)
            print (e.message)
        }
    }



    companion object {
        private val logger: Logger = LoggerFactory.getLogger(JwtAuthFilter::class.java)
    }
}