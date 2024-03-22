package com.shinoaki.afdian.api;

import com.shinoaki.afdian.config.TokenConfig;
import com.shinoaki.afdian.model.PageData;
import com.shinoaki.afdian.model.RequestBody;
import com.shinoaki.afdian.model.request.sponsor.QuerySponsor;
import com.shinoaki.afdian.model.response.sponsor.SponsorList;
import com.shinoaki.afdian.utils.ApiUtils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;

/**
 * 查询赞助
 */
public class ApiSponsor {
    private ApiSponsor() {
    }

    public static PageData<SponsorList> querySponsor(QuerySponsor sponsor) throws IOException, InterruptedException {
        var uri = URI.create(TokenConfig.HOME + "/api/open/query-sponsor");
        var data = ApiUtils.send(HttpRequest.newBuilder(uri).POST(HttpRequest.BodyPublishers.ofString(new RequestBody<>(sponsor).toJson())));
        if (data.getEc() != 200) {
            throw new IOException(STR."请求业务码异常code=\{data.getEc()} msg:\{data.getEm()}");
        }
        return PageData.to(data.getData());
    }
}
