public int gcd(int q,int p){
	if(p==0){
		return q;
	}
	int r = p%q;
	return gcd(q,r);
}