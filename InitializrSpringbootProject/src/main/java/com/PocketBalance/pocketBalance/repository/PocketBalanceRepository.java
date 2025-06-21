/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PocketBalance.pocketBalance.repository;

import com.PocketBalance.pocketBalance.domain.PocketBalance;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jstev
 */
public interface PocketBalanceRepository 
        extends JpaRepository<PocketBalance, Long>{
    
}
