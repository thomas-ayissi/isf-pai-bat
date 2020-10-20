package interfaceSwitch;

public class Detecteur {
 private ISwitchable elem=null;//using

public ISwitchable getElem() {
	return elem;
}

public void setElem(ISwitchable elem) {
	this.elem = elem;
}

public void detect() throws InterruptedException {
	if (elem!=null) {
		elem.on();
		Thread.sleep(5000);
		elem.off();
	}else System.out.println("Rien de connecté!!!");
	
}
 
}
