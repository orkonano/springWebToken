package orko.dev.springWebToken;

import java.util.Random;

public class TokenManagerImpl implements TokenManager {

	@Override
	public String getTokenKey() {
		return "_synchronizerToken";
	}

	@Override
	public String nextToken() {
		long seed = System.currentTimeMillis();
		Random r = new Random();
		r.setSeed(seed);
		return Long.toString(seed) + Long.toString(Math.abs(r.nextLong()));
	}

}
