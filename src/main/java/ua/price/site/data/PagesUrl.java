package ua.price.site.data;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import ua.price.properties.PropertyReader;

@Accessors(fluent = true, chain = true)
@Getter
@Setter
public class PagesUrl {
    private String baseUrl;
    private String accountUrl;
    private String searchUrl;
    private String itemUrl;

    public PagesUrl() {
        this.baseUrl = PropertyReader.getProperty("base_url");
        this.accountUrl = PropertyReader.getProperty("account_url");
        this.searchUrl = PropertyReader.getProperty("search_url");
        this.itemUrl = PropertyReader.getProperty("item_url");
    }
}
