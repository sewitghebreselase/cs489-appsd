package edu.miu.cs.cs489.lesson6.citylibraryapp.service.Implementation;

import edu.miu.cs.cs489.lesson6.citylibraryapp.dao.AddressRepository;
import edu.miu.cs.cs489.lesson6.citylibraryapp.models.Address;
import edu.miu.cs.cs489.lesson6.citylibraryapp.service.AddressService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public Address save(Address address) {
        return addressRepository.save(address);
    }
}