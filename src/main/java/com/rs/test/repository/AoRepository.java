package com.rs.test.repository;

import com.rs.test.model.Ao;
import com.rs.test.model.ChatLieu;
import com.rs.test.model.Hang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AoRepository extends JpaRepository<Ao , UUID> {
    Ao findByTenAo(String tenAo);
    List<Ao> findByHang(Hang hang);
    List<Ao>findByChatLieu(ChatLieu chatLieu);
    List<Ao> findByTrangThai(int trangThai);
    List<Ao> findAllByOrderByTgThemDesc();
    Ao findByMaAo(String maAo);
}
