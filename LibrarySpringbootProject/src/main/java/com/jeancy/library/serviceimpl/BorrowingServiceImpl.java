package com.jeancy.library.serviceimpl;

import com.jeancy.library.model.Borrowing;
import com.jeancy.library.repositoty.BorrowingRepository;
import com.jeancy.library.service.BorrowingService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jeancy
 */
@Service
public class BorrowingServiceImpl implements BorrowingService {
    private final BorrowingRepository borrowingRep;

    public BorrowingServiceImpl(BorrowingRepository borrowingRepp) {
        this.borrowingRep = borrowingRepp;
    }

    
    @Override
    public List<Borrowing> getAllBorrowings() {
        return borrowingRep.findAll();
    }

    @Override
    public Borrowing saveBorrowing(Borrowing borrowing) {
       return  borrowingRep.save(borrowing);
    }

    @Override
    public Borrowing getBorrowingById(Long id) {
        return borrowingRep.findById(id).get();
    }

    @Override
    public Borrowing updateBorrowing(Borrowing borrowing) {
        return borrowingRep.save(borrowing);
    }

    @Override
    public void deleteBorrowingById(Long id) {
        borrowingRep.deleteById(id);
    }
    
}
