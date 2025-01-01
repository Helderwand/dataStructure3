public class TestClass1 {
    public static void main(String[] args) {

        MuseumSecuritySystem museum1 = new MuseumSecuritySystem();

        Accounts user1 = new Accounts("gokhan", "{[(abacaba)]}", 75, new int[]{50, 25, 0});
        Accounts user2 = new Accounts("sibel", "{[a(abacaba)]}", 123, new int[]{121, 2, 0});
        Accounts user3 = new Accounts("gizem", "{[(aba)caba)]}", 555, new int[]{123, 325, 126});
        Accounts user4 = new Accounts("alper", "{[(abacaba)]}", 35, new int[]{4, 17, 29});

        museum1.IsItValid(user1, museum1);
        museum1.IsItValid(user2, museum1);
        museum1.IsItValid(user3, museum1);
        museum1.IsItValid(user4, museum1);
    }
}
