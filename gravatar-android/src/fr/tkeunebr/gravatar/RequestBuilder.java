package fr.tkeunebr.gravatar;

public class RequestBuilder {
	private static final String GRAVATAR_ENDPOINT = "http://www.gravatar.com/avatar/";
	private static final String GRAVATAR_ENDPOINT_SECURE = "https://secure.gravatar.com/avatar/";
	private final StringBuilder builder;
	private final Gravatar gravatar;

	public RequestBuilder(Gravatar gravatar, String email) {
		final String hash = Utils.convertEmailToHash(email);
		builder = gravatar.ssl ? new StringBuilder(GRAVATAR_ENDPOINT_SECURE.length() + hash.length() + 1).append(GRAVATAR_ENDPOINT_SECURE) :
				new StringBuilder(GRAVATAR_ENDPOINT.length() + hash.length() + 1).append(GRAVATAR_ENDPOINT);

		builder.append(hash);
		if (gravatar.extension) {
			builder.append(".jpg");
		}
		builder.append("?");
		this.gravatar = gravatar;
	}

	public RequestBuilder size(int sizeInPixels) {
		if (sizeInPixels >= Gravatar.MIN_IMAGE_SIZE_PIXEL && sizeInPixels <= Gravatar.MAX_IMAGE_SIZE_PIXEL) {
			builder.append("&size=").append(sizeInPixels);
			return this;
		}
		throw new IllegalArgumentException("Requested image size must be between " + Gravatar.MIN_IMAGE_SIZE_PIXEL
				+ " and " + Gravatar.MAX_IMAGE_SIZE_PIXEL);
	}

	public RequestBuilder forceDefault() {
		builder.append("&f=y");
		return this;
	}

	public RequestBuilder force404() {
		builder.append("&d=404");
		return this;
	}

	public RequestBuilder defaultImage(int gravatarDefaultImage) {
		switch (gravatarDefaultImage) {
			case Gravatar.DefaultImage.MYSTERY_MAN:
				builder.append("&d=mm");
				break;
			case Gravatar.DefaultImage.IDENTICON:
				builder.append("&d=identicon");
				break;
			case Gravatar.DefaultImage.MONSTER:
				builder.append("&d=monsterid");
				break;
			case Gravatar.DefaultImage.WAVATAR:
				builder.append("&d=wavatar");
				break;
			case Gravatar.DefaultImage.RETRO:
				builder.append("&d=retro");
				break;
			case Gravatar.DefaultImage.BLANK:
				builder.append("&d=blank");
				break;
		}
		return this;
	}

	public RequestBuilder defaultImage(String url) {
		builder.append("&d=").append(Utils.encode(url));
		return this;
	}

	public RequestBuilder rating(int rating) {
		switch (rating) {
			case Gravatar.Rating.g:
				builder.append("&r=g");
				break;
			case Gravatar.Rating.pg:
				builder.append("&r=pg");
				break;
			case Gravatar.Rating.r:
				builder.append("&r=r");
				break;
			case Gravatar.Rating.x:
				builder.append("&r=x");
				break;
		}
		return this;
	}

	public String build() {
		final int size = builder.length() - 1;
		if (builder.charAt(size) == '?') {
			builder.deleteCharAt(size);
		}
		return builder.toString();
	}
}