package com.microsys.app.service.test.fixture;

import java.util.ArrayList;
import java.util.List;

import com.microsys.app.model.dto.AddressDto;
import com.microsys.app.model.dto.EmailDto;
import com.microsys.app.model.dto.PhoneDto;
import com.microsys.app.model.dto.company.CompanyDto;

public class CompanyFixture {

	public static CompanyDto createCompany() {

		CompanyDto companyDto = new CompanyDto();
		AddressDto addressDto = new AddressDto();
		PhoneDto phoneDto = new PhoneDto();
		EmailDto emailDto = new EmailDto();
		addressDto.setAddrLineOne("addrLineOne");
		addressDto.setAddrLineTwo("addrLineTwo");
		addressDto.setZipCode("743166");
		companyDto.setAddress(addressDto);
		
		phoneDto.setPhoneNo("9903848055");
		phoneDto.setPhoneType("Mobile");
		List<PhoneDto> arrayList = new ArrayList<PhoneDto>(1);
		arrayList.add(phoneDto);

		emailDto.setEmailDetl("Abhideep.Baskhi@gmail.com");
		emailDto.setEmailType("Email");
		List<EmailDto> arrayList2 = new ArrayList<EmailDto>(1);
		arrayList2.add(emailDto);

		companyDto.setEmail(arrayList2);
		companyDto.setPhone(arrayList);
		companyDto.setCompName("Microsys");
		companyDto.setInvFormat("MIC/INV");
		companyDto.setOwnerName("Joydeep");
		
		
		
		return companyDto;
	}

}
