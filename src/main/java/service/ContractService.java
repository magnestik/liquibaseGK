package service;

import org.springframework.stereotype.Service;

@Service
class ContractService {
    Integer averageAmount(Integer amount1, Integer amount2) {
        return (amount1 + amount2) / 2;
    }
}
