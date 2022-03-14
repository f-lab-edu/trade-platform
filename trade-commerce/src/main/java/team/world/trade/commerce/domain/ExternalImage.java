package team.world.trade.commerce.domain;

public class ExternalImage extends Image {

    public ExternalImage(String path) {
        super(path);
    }

    @Override
    String getUrl() {
        return getPath();
    }

    @Override
    Boolean hasThumbnail() {
        return null;
    }

    @Override
    String getThumbnailUrl() {
        return null;
    }
}
