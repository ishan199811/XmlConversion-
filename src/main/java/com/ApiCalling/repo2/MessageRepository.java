package com.ApiCalling.repo2;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ApiCalling.smarshModel.Message;

public interface MessageRepository extends JpaRepository<Message , Long>{

}
