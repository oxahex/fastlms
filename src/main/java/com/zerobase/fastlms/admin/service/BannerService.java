package com.zerobase.fastlms.admin.service;

import com.zerobase.fastlms.admin.dto.BannerDto;
import com.zerobase.fastlms.admin.entity.Banner;
import com.zerobase.fastlms.admin.model.BannerInput;
import com.zerobase.fastlms.admin.repository.BannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class BannerService {

    private final BannerRepository bannerRepository;
//    private final BannerMapper bannerMapper;

    public Page<BannerDto> list(Pageable pageable) {
        Page<Banner> bannerList = bannerRepository.findAll(pageable);
        return bannerList.map(BannerDto::of);
    }

    public BannerDto getById(Long bannerId) {
        return bannerRepository.findById(bannerId).map(BannerDto::of).orElse(null);
    }

    public void addBanner(BannerInput bannerInput) {
        Banner banner = Banner.builder()
                .bannerName(bannerInput.getBannerName())
                .alterText(bannerInput.getAlterText())
                .targetUrl(bannerInput.getTargetUrl())
                .openBlankYn(bannerInput.getOpenBlankYn())
                .sortOrder(bannerInput.getSortOrder())
                .frontShowYn(bannerInput.getFrontShowYn())
                .regDt(LocalDateTime.now())
                .fileName(bannerInput.getFileName())
                .urlFileName(bannerInput.getUrlFileName()).build();

        bannerRepository.save(banner);
    }

    public void editBanner(BannerInput bannerInput) {
        // 수정
    }
}