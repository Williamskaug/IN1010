class TestLegemiddel {
    public static void main(String[] args){
        //Oppretter legemiddel-objekter
        Narkotisk morfin = new Narkotisk("morfin", 15000, 1, 10);
        Vanedannende paracet = new Vanedannende("paracet", 100, 1, 4);
        Vanlig hostesaft = new Vanlig("hostesaft", 220, 100);

        //Tester Narkotisk
        System.out.println("Tester narkotisk");
        System.out.println(morfin.hentNavn());
        System.out.println(morfin.hentId());
        System.out.println(morfin.hentPris());
        System.out.println(morfin.hentVirkestoff());
        System.out.println(morfin.hentNarkotiskStyrke());
        System.out.println(" ");

        //Tester Vanedannende
        System.out.println("Tester vanedannende");
        System.out.println(paracet.hentNavn());
        System.out.println(paracet.hentId());
        System.out.println(paracet.hentPris());
        System.out.println(paracet.hentVirkestoff());
        System.out.println(paracet.hentVanedannendeStyrke());
        System.out.println(" ");

        //Tester Vanlig        
        System.out.println("Tester vanlig");
        System.out.println(hostesaft.hentNavn());
        System.out.println(hostesaft.hentId());
        System.out.println(hostesaft.hentPris());
        System.out.println(hostesaft.hentVirkestoff());
        System.out.println(" ");

    }
}
