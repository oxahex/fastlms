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

        System.out.println("edit banner input: " + bannerInput);
        Banner banner = bannerRepository.findById(bannerInput.getId())
                .orElseThrow(() -> new RuntimeException("해당 배너가 없습니다."));

        banner.setBannerName(bannerInput.getBannerName());
        banner.setAlterText(bannerInput.getAlterText());
        banner.setTargetUrl(bannerInput.getTargetUrl());
        banner.setOpenBlankYn(bannerInput.getOpenBlankYn());
        banner.setSortOrder(bannerInput.getSortOrder());
        banner.setFrontShowYn(bannerInput.getFrontShowYn());
        banner.setFileName(bannerInput.getFileName());
        banner.setUrlFileName(bannerInput.getUrlFileName());

        bannerRepository.save(banner);
    }

    public void deleteBanners(String idList) {

        if (idList != null && !idList.isEmpty()) {
            String[] ids = idList.split(",");
            for (String x : ids) {
                long id = 0L;
                try {
                    id = Long.parseLong(x);
                } catch (Exception e) {
                }

                if (id > 0) {
                    bannerRepository.deleteById(id);
                }
            }
        }
    }
}