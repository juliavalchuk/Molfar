package ua.julia.spring.molfar;

/**
 * Created by julia
 */
public class Main { //20401 books, 223 classes

//    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
//
//        String path = "//Users//julia//IdeaProjects//ParseHttp//work1.xml";
//        MongoBookRepository repository = new MongoBookRepository();
//
//        for (int i = 2; i < 138570; i++) { //138570
//            path = "//Users//julia//IdeaProjects//ParseHttp//work" + i + ".xml";
//
//
//            try {
//                repository.save(getJsonOfBookByXmlPath(path));
//            } catch (IOException e) {
//               // e.printStackTrace();
//            } catch (SAXException e) {
//                e.printStackTrace();
//            } catch (ParserConfigurationException e) {
//              //  e.printStackTrace();
//            } catch (Exception e){
//             //   e.printStackTrace();
//            }
//        }
//
//
//    }
//
//    static Book getJsonOfBookByXmlPath(String path) throws IOException, SAXException, ParserConfigurationException {
//        String xml = readFile(path, StandardCharsets.UTF_8);
////        xml = xml.replaceAll("&laquo;", "");
////        xml = xml.replaceAll("&raquo;", "");
////        xml = xml.replaceAll("&copy;", "");
////        xml = xml.replaceAll("&nbsp;", ""); //shy, deg, sup1
////        xml = xml.replaceAll("&shy;", "");
////        xml = xml.replaceAll("&deg;", "");
////        xml = xml.replaceAll("&sup1;", ""); // eacute, egrave, Eacute, ordm, auml
//        xml = xml.replaceAll("&\\w*?;", "");
//
//        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
//        Document doc = docBuilder.parse(new InputSource(new java.io.StringReader(xml)));
//
//        // normalize text representation
//        doc.getDocumentElement().normalize();
//
//
//        Book book = new Book();
//        Set<Clazz> set = new HashSet<Clazz>();
//
//        Node node = doc.getElementsByTagName("author").item(0);
//        book.setWriter(node.getFirstChild().getNodeValue().replaceAll("^\\s*", "").replaceAll("\\s*$", ""));
//
//        node = doc.getElementsByTagName("name").item(0);
//        book.setTitle(node.getFirstChild().getNodeValue().replaceAll("^\\s*", "").replaceAll("\\s*$", ""));
//
//
//        try {
//            node = doc.getElementsByTagName("othername").item(0);
//            book.setOthername(node.getFirstChild().getNodeValue().replaceAll("^\\s*", "").replaceAll("\\s*$", ""));
//        } catch (Exception e) {
//            // e.printStackTrace();
//        }
//
//        NodeList classes = doc.getElementsByTagName("classname");
//
//        for (int i = 0; i < classes.getLength(); i++) {
//            Node aNode = classes.item(i);
//            System.out.println(aNode.getFirstChild().getNodeValue());
//
//            Node theAttribute = aNode.getAttributes().item(0);
//            String tagname = "";
//
//            tagname = theAttribute.getNodeValue();
//
//            NodeList nodes = aNode.getChildNodes();
//            Node node1;
//            String nodename;
//
//            Clazz clazz = new Clazz();
//            for (int j = 0; j < nodes.getLength(); j++) {
//                node1 = nodes.item(j);
//                nodename = node1.getNodeName();
//                if(nodename.equals("tag")) {
//                    if(tagname.equals("release")){
//                        book.setYear(Integer.parseInt(node1.getFirstChild().getNodeValue().replaceAll("\\s", "")));
//                        break;
//                    } else {
//                        if (tagname.equals("films")){
//
//                            try {
//                                Integer.parseInt(node1.getFirstChild().getNodeValue().replaceAll("\\s", ""));
//                                break;
//                            } catch (NumberFormatException e) {
//                                //e.printStackTrace();
//                            }
//                        } else if (tagname.equals("type")){
//
//                            if(node1.getFirstChild().getNodeValue().contains("|")){
//                                break;
//                            }
//                        }
//
//                        clazz.setName(tagname + ": " + node1.getFirstChild().getNodeValue().replaceAll("^\\s*", "").replaceAll("\\s*$", ""));
//                    }
//                } else if(nodename.equals("amount"))
//                {
//                    clazz.setAmount(Integer.parseInt(node1.getFirstChild().getNodeValue().replaceAll("\\s", "")));
//                }
//                else if(nodename.equals("of"))
//                {
//                    clazz.setTotalAmount(Integer.parseInt(node1.getFirstChild().getNodeValue().replaceAll("\\s", "")));
//
//                    set.add(clazz);
//                    clazz = new Clazz();
//                }
//
//
//            }
//        }
//
//        book.setClazzList(set);
//
//        return book;
//    }
//
//    static String readFile(String path, Charset encoding)
//            throws IOException
//    {
//        byte[] encoded = Files.readAllBytes(Paths.get(path));
//        return new String(encoded, encoding);
//    }
}
