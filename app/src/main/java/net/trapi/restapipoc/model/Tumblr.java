package net.trapi.restapipoc.model;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

import java.io.Serializable;
import java.util.List;

@Root(name = "tumblr", strict=false)
public class Tumblr {
    @Element(name="tumblelog", required = false)
    Tumblelog tumblelog;


    @Element(name="posts", required = false)
    Posts posts;


    @Attribute(name="version", required = false)
    String version;

    public Tumblr(){};

    public Tumblelog getTumblelog() { return this.tumblelog; }
    public void setTumblelog(Tumblelog _value) { this.tumblelog = _value; }


    public Posts getPosts() { return this.posts; }
    public void setPosts(Posts _value) { this.posts = _value; }


    public String getVersion() { return this.version; }
    public void setVersion(String _value) { this.version = _value; }


    @Root(strict = false)
    public static class Tumblelog {

        @Attribute(name="name", required = false)
        String name;


        @Attribute(name="timezone", required = false)
        String timezone;


        @Attribute(name="title", required = false)
        String title;



        public String getName() { return this.name; }
        public void setName(String _value) { this.name = _value; }


        public String getTimezone() { return this.timezone; }
        public void setTimezone(String _value) { this.timezone = _value; }


        public String getTitle() { return this.title; }
        public void setTitle(String _value) { this.title = _value; }


    }

    @Root(strict = false)
    public static class Posts {

        @ElementList(name = "post", inline = true, required = false)
        List<Post> post;


        @Attribute(name="start", required = false)
        String start;


        @Attribute(name="total", required = false)
        String total;



        public List<Post> getPost() { return this.post; }
        public void setPost(List<Post> _value) { this.post = _value; }


        public String getStart() { return this.start; }
        public void setStart(String _value) { this.start = _value; }


        public String getTotal() { return this.total; }
        public void setTotal(String _value) { this.total = _value; }


    }

    @Root(strict = false)
    public static class Post implements Serializable {

        public static final String POST_PHOTO = "photo";
        public static final String POST_LINK = "link";
        public static final String POST_REGULAR = "regular";
        public static final String POST_CONVERSATION = "conversation";

        @Element(name="link-text", required = false)
        String linkText;


        @Element(name="link-url", required = false)
        String linkUrl;

        @Element(name="link-description", required = false)
        String linkDescription;

        @Attribute(name="id", required = false)
        String id;


        @Attribute(name="url", required = false)
        String url;


        @Attribute(name="url-with-slug", required = false)
        String urlWithSlug;


        @Attribute(name="type", required = false)
        String type;


        @Attribute(name="date-gmt", required = false)
        String dateGmt;


        @Attribute(name="date", required = false)
        String date;


        @Attribute(name="unix-timestamp", required = false)
        String unixTimestamp;


        @Attribute(name="format", required = false)
        String format;


        @Attribute(name="reblog-key", required = false)
        String reblogKey;


        @Attribute(name="slug", required = false)
        String slug;


        @Element(name="conversation-text", required = false)
        String conversationText;


        @ElementList(name = "conversation", required = false)
        List<Line> conversation;


        @Element(name="conversation-title", required = false)
        String conversationTitle;


        @Element(name="regular-title", required = false)
        String regularTitle;


        @Element(name="regular-body", required = false)
        String regularBody;


        @Element(name="quote-text", required = false)
        String quoteText;


        @Element(name="quote-source", required = false)
        String quoteSource;


        @Element(name="photo-caption", required = false)
        String photoCaption;


        @Element(name="photo-link-url", required = false)
        String photoLinkUrl;


        @ElementList(name="photo-url", inline = true, required = false)
        List<PhotoUrl> photUrl;

        @ElementList(name="tag", inline = true, required = false)
        List<Tag> tag;

        @Attribute(name="width", required = false)
        String width;


        @Attribute(name="height", required = false)
        String height;



        public String getLinkText() { return this.linkText; }
        public void setLinkText(String _value) { this.linkText = _value; }


        public String getLinkUrl() { return this.linkUrl; }
        public void setLinkUrl(String _value) { this.linkUrl = _value; }


        public String getId() { return this.id; }
        public void setId(String _value) { this.id = _value; }


        public String getUrl() { return this.url; }
        public void setUrl(String _value) { this.url = _value; }


        public String getUrlWithSlug() { return this.urlWithSlug; }
        public void setUrlWithSlug(String _value) { this.urlWithSlug = _value; }


        public String getType() { return this.type; }
        public void setType(String _value) { this.type = _value; }


        public String getDateGmt() { return this.dateGmt; }
        public void setDateGmt(String _value) { this.dateGmt = _value; }


        public String getDate() { return this.date; }
        public void setDate(String _value) { this.date = _value; }


        public String getUnixTimestamp() { return this.unixTimestamp; }
        public void setUnixTimestamp(String _value) { this.unixTimestamp = _value; }


        public String getFormat() { return this.format; }
        public void setFormat(String _value) { this.format = _value; }


        public String getReblogKey() { return this.reblogKey; }
        public void setReblogKey(String _value) { this.reblogKey = _value; }


        public String getSlug() { return this.slug; }
        public void setSlug(String _value) { this.slug = _value; }


        public String getConversationText() { return this.conversationText; }
        public void setConversationText(String _value) { this.conversationText = _value; }


        public List<Line> getConversation() { return this.conversation; }
        public void setConversation(List<Line> _value) { this.conversation = _value; }


        public String getConversationTitle() { return this.conversationTitle; }
        public void setConversationTitle(String _value) { this.conversationTitle = _value; }


        public String getRegularTitle() { return this.regularTitle; }
        public void setRegularTitle(String _value) { this.regularTitle = _value; }


        public String getRegularBody() { return this.regularBody; }
        public void setRegularBody(String _value) { this.regularBody = _value; }


        public String getQuoteText() { return this.quoteText; }
        public void setQuoteText(String _value) { this.quoteText = _value; }


        public String getQuoteSource() { return this.quoteSource; }
        public void setQuoteSource(String _value) { this.quoteSource = _value; }


        public String getPhotoCaption() { return this.photoCaption; }
        public void setPhotoCaption(String _value) { this.photoCaption = _value; }


        public String getPhotoLinkUrl() { return this.photoLinkUrl; }
        public void setPhotoLinkUrl(String _value) { this.photoLinkUrl = _value; }


        public List<PhotoUrl> getPhotoUrl() { return this.photUrl; }
        public void setPhotoUrl(List<PhotoUrl> _value) { this.photUrl = _value; }


        public String getWidth() { return this.width; }
        public void setWidth(String _value) { this.width = _value; }


        public String getHeight() { return this.height; }
        public void setHeight(String _value) { this.height = _value; }


        public String getDisplayTitle() {
            switch (type) {
                case POST_CONVERSATION:
                    return getConversationTitle();
                case POST_LINK:
                    return getLinkText();
                default:
                case POST_REGULAR:
                    return getRegularTitle();
            }
        }

        public String getDisplayText() {
            switch (type) {
                case POST_CONVERSATION:
                    return getConversationText();
                case POST_LINK:
                    return getLinkText();
                case POST_PHOTO:
                    return getPhotoCaption();
                default:
                case POST_REGULAR:
                    return getRegularBody();
            }
        }
    }

    @Root(strict = false)
    public static class Line implements Serializable {

        @Attribute(name="name", required = false)
        String name;


        @Attribute(name="label", required = false)
        String label;



        public String getName() { return this.name; }
        public void setName(String _value) { this.name = _value; }


        public String getLabel() { return this.label; }
        public void setLabel(String _value) { this.label = _value; }


    }

    @Root(strict = false)
    public static class Tag implements Serializable {

        @Text(required = false)
        public String tag;

    }

    @Root(name = "photo-url", strict = false)
    public static class PhotoUrl implements Serializable {

        @Attribute(name="max-width", required = false)
        String maxWidth;

        @Text(required = false)
        String link;

        public String getMaxWidth() { return this.maxWidth; }
        public void setMaxWidth(String _value) { this.maxWidth = _value; }

        public String getLink() { return link; }

        public void setLink(String link) { this.link = link; }
    }
}
