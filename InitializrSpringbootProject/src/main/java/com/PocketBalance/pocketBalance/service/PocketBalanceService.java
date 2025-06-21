/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PocketBalance.pocketBalance.service;

import com.PocketBalance.pocketBalance.domain.PocketBalance;
import com.PocketBalance.pocketBalance.repository.PocketBalanceRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jstev
 */
@Service
public class PocketBalanceService {

    @Autowired
    private PocketBalanceRepository pocketBalanceRepository;

    @Transactional(readOnly = true)
    public List<PocketBalance> getBalances() {
        var lista = pocketBalanceRepository.findAll();
        return lista;
    }

    @Transactional(readOnly = true)
    public PocketBalance getBalance(PocketBalance pocketBalance) {
        return pocketBalanceRepository.findById(pocketBalance.getId_transaccion()).orElse(null);
    }

    @Transactional
    public void save(PocketBalance pocketBalance) {
        pocketBalanceRepository.save(pocketBalance);
    }

    @Transactional
    public boolean delete(PocketBalance pocketBalance) {
        try {
            pocketBalanceRepository.delete(pocketBalance);
            pocketBalanceRepository.flush();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
