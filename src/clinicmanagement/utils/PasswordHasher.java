/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clinicmanagement.utils;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author nguye
 */
public class PasswordHasher {
    public static void main(String[] args) {
        String oldPassword = "admin123";
        String hashedPassword = BCrypt.hashpw(oldPassword, BCrypt.gensalt(12));
        System.out.println("Mat khau goc: " + oldPassword);
        //luu mat khau sau khi bam vao csdl
        System.out.println("Mat khau da bam:");
        System.out.println(hashedPassword);
    }
}
