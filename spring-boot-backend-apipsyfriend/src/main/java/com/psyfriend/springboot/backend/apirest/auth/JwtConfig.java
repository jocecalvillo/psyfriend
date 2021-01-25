package com.psyfriend.springboot.backend.apirest.auth;

public class JwtConfig {
	public static final String LLAVE_SECRETA="clave.secreta.aqui";
	public static final String RSA_PRIVATE="-----BEGIN RSA PRIVATE KEY-----\r\n"
			+ "MIIEpgIBAAKCAQEAummv8ARQngSzWgBT8gc4luinlKO/kaXkl2QX8QBKBLb9w1Ft\r\n"
			+ "q2BDgqPDIzt8Q0iNRDi+Zhc/1vLW9kIwLzPn2ehNScJdRoyk4+taBgvuh8QOw/pB\r\n"
			+ "u3zduWBPNAoL6HjSYp4qMB9HbKQMdtnsFb3dhtu6wKGouM67fToBo6cF5XKUa0TH\r\n"
			+ "XLL0M42MAj59u92tP94yZCQOnHTPcpBWWflsguT9bR77gIMJfuptO05CRaxcGyZ3\r\n"
			+ "V28wZ4IGaN3uTUll8byGQY2sjcgS7SjhtoFllFsCJC8fozkBNXjYh3vz+oJLsHqX\r\n"
			+ "Ei/gdzqXept8DjqqIeO8WLvZn41Kl1tSQua2DwIDAQABAoIBAQCA7vK6rzFXambm\r\n"
			+ "vE1TnLz+W+L1AyFQSw7Fy3xnu8x2YF86hgq1uzpWlJA2wUEchIT5B8phcHk+Ye5e\r\n"
			+ "m78aFuupI2y5tI6xajvuTO2SOxR7oRaZZHGsjRwKyNtfYgeEfnT9sun5KNlNAlaA\r\n"
			+ "qhAJpa4gRcBw1h+N26eAYOubVr3USXClbgNlJqtMbvPslcc3cXFBWKtkaMcxyHeJ\r\n"
			+ "TSYKOix8T5QnCiX7TIBym9/v/mgDNTwzU6dYlV9v3IlM7cQ82rwtebUj9gjUABDV\r\n"
			+ "IoUdkBpF90VMYsumqRF3rfuN1YP4QStguhVddhQcChYO+5zMVtFj5I+lv037UD5L\r\n"
			+ "c/dksJdpAoGBAPXGWUOMev/F3YPta0L994j/bFqKPzqQVheFGOp19sUQY+zCY8hZ\r\n"
			+ "dUFU0cZDxujvRnRYdguo+cx3B3ZmDQfOwl8Ftk4eHiFgajqG2VROrWP94a9W4Dtd\r\n"
			+ "6dd2llGhzDiFid+6pzPihrWLcvlmw5QrBRwVTyxBiOR5IZMOCIZe/DrTAoGBAMIr\r\n"
			+ "GPkxLoyLw+uevEo/tJAjlf1BNzkublp71q11CKotkEV/KIgUIEGxyhGFWWlPovE3\r\n"
			+ "kShJj2XAPLQXQ/3pTRUebJKo9f3Yik3c6Ih5iaxmJmX0dmKX+YceaseTFZOWDxOJ\r\n"
			+ "UNksOAsEXkiYVoDtKwd/KiubV4KqA6JH06W0A1pVAoGBAIxak0tiBDPgmRnoEaMW\r\n"
			+ "SbAwvX4PCQC2wJN57LqoVx4+t/HTKQyXGcEPYSSqPAN18XQruG38N3suVlKlALf+\r\n"
			+ "uT1uk6eUx3wkBUYbEC13KMm7iJCLOk5s2Ue0by97CJcWm5/qheW5bVhrpGMM7o/E\r\n"
			+ "6YwaFzaczkI7cpL6JqAlykEFAoGBAInWhngATgdAAOl3WjtrVgcs/AE5FrblGzno\r\n"
			+ "x9GDT49foRd02ZUglHWOfOBLRdnYytdqlwV+kumsumsuSPorcKkZXAIRJ+/4lNYJ\r\n"
			+ "iJm5jd5w9blS/een81/UXAEpjRukXzeDN320QmSvyS7H1kDYHL/JqmoicNE1WDcP\r\n"
			+ "vlPXormxAoGBALLDA4AgTXTu2R92LWFn1w1k4vESbdgljWzL9YIXK9O1JdrwRN/N\r\n"
			+ "cYBi9v7ZlLBBp4kbusa2P/JEVvdXumLSVEyJJNaPG/gA8U0KG5gc1PkKJVwPbwPE\r\n"
			+ "JkBMTm5LKW8F8JPK4rYlI8A8yPf6ParURkIZoKZC5bAmgVchjFMvgBpL\r\n"
			+ "-----END RSA PRIVATE KEY-----";

	public static final String RSA_PUBLIC="-----BEGIN PUBLIC KEY-----\r\n"
			+ "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAummv8ARQngSzWgBT8gc4\r\n"
			+ "luinlKO/kaXkl2QX8QBKBLb9w1Ftq2BDgqPDIzt8Q0iNRDi+Zhc/1vLW9kIwLzPn\r\n"
			+ "2ehNScJdRoyk4+taBgvuh8QOw/pBu3zduWBPNAoL6HjSYp4qMB9HbKQMdtnsFb3d\r\n"
			+ "htu6wKGouM67fToBo6cF5XKUa0THXLL0M42MAj59u92tP94yZCQOnHTPcpBWWfls\r\n"
			+ "guT9bR77gIMJfuptO05CRaxcGyZ3V28wZ4IGaN3uTUll8byGQY2sjcgS7SjhtoFl\r\n"
			+ "lFsCJC8fozkBNXjYh3vz+oJLsHqXEi/gdzqXept8DjqqIeO8WLvZn41Kl1tSQua2\r\n"
			+ "DwIDAQAB\r\n"
			+ "-----END PUBLIC KEY-----";
}
