package com.zanabazar.JarSoftTestTask.Service;

import com.zanabazar.JarSoftTestTask.entity.Banner;
import com.zanabazar.JarSoftTestTask.entity.Category;
import com.zanabazar.JarSoftTestTask.entity.Request;
import com.zanabazar.JarSoftTestTask.repository.BannerRepo;
import com.zanabazar.JarSoftTestTask.repository.CategoryRepo;
import com.zanabazar.JarSoftTestTask.repository.RequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Service
public class RandomBannerService {

    @Autowired
    private RequestRepo requestRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private BannerRepo bannerRepo;

    public ResponseEntity<String> getBanner(String category, HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        String ipAddress = request.getRemoteAddr();

        List<Banner> banners;

        Category responseCategory = categoryRepo.findByReqName(category);
        if (responseCategory != null) {
            banners = bannerRepo.findByCategoryOrderByPriceDesc(responseCategory);

            for (Banner banner : banners) {
                Request lastRequest = requestRepo.findByUserAgentAndIpAddressAndBanner(userAgent, ipAddress, banner);
                if (lastRequest == null) {
                    Request newRequest = new Request();
                    newRequest.setIpAddress(ipAddress);
                    newRequest.setUserAgent(userAgent);
                    newRequest.setDate(new Date());
                    newRequest.setBanner(banner);
                    requestRepo.save(newRequest);
                    return ResponseEntity.status(HttpStatus.OK)
                            .body(banner.getContent());
                }
            }
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
    }
}
