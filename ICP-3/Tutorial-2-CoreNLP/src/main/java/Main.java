import edu.stanford.nlp.coref.CorefCoreAnnotations;
import edu.stanford.nlp.coref.data.CorefChain;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations;
import edu.stanford.nlp.util.CoreMap;
import org.apache.commons.lang3.StringUtils;


import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.*;


/**
 * Created by Mayanka on 13-Jun-16.
 */
public class Main {

    public static void main(String args[]) {

        String[] abstracts = new String[1];

        abstracts[0] = "Resistance to trastuzumab has become a leading cause of mortality in breast cancer patients and is one of the major obstacles for improving the clinical outcome. Cell behavior can be modulated by long non-coding RNAs (lncRNAs), but the contribution of lncRNAs in trastuzumab resistance to breast cancer is largely unknown. To this end, the involvement and regulatory function of lncRNA AGAP2-AS1 in human breast cancer are yet to be investigated. Trastuzumab-resistant SKBR-3 and BT474 cells were obtained by continuous culture with 5 mg/mL trastuzumab for 6 months. RT-qPCR assay was used to determine the expression of AGAP2-AS1 in tissues and cells. RNA fluorescence in situ hybridization was used to investigate the subcellular location of AGAP2-AS1 in breast cancer cells.Bioinformatic analysis, chromatin immunoprecipitation (ChIP), RNA immunoprecipitation (RIP), western blotting, and immunofluorescence were carried out to verify the regulatory interaction of AGAP2-AS1, CREB-binding protein (CBP), and MyD88.In addition, a series of in vitro assays and a xenograft tumor model were used to analyze the functions of AGAP2-AS1 in breast cancer cells. AGAP2-AS1 was upregulated and transcriptionally induced by SP1 in breast cancer. Overexpression of AGAP2-AS1 promoted cell growth, suppressed apoptosis, and caused trastuzumab resistance, whereas knockdown of AGAP2-AS1 showed an opposite effect. MyD88 was identified as a downstream target of AGAP2-AS1 and mediated the AGAP2-AS1-induced oncogenic effects. Mechanistically, the RIP assay revealed that AGAP2-AS1 could bind to CBP, a transcriptional co-activator. ChIP assays showed that AGAP2-AS1-bound CBP increased the enrichment of H3K27ac at the promoter region of MyD88, thus resulting in the upregulation of MyD88. Gain- and loss-of-function assays confirmed that the NF-κB pathway was activated by MyD88 and AGAP2-AS1. Furthermore, high AGAP2-AS1 expression was associated with poor clinical response to trastuzumab therapy in breast cancer patients. AGAP2-AS1 could promote breast cancer growth and trastuzumab resistance by activating the NF-κB signaling pathway and upregulating MyD88 expression. Therefore, AGAP2-AS1 may serve as a novel biomarker for prognosis and act as a therapeutic target for the trastuzumab treatment.";
        //abstracts[1] = "Triple-negative breast cancer (TNBC) lacks prognostic and predictive markers. Here, we use high-throughput phosphoproteomics to build a functional TNBC taxonomy. A cluster of 159 phosphosites is upregulated in relapsed cases of a training set (n = 34 patients), with 11 hyperactive kinases accounting for this phosphoprofile. A mass-spectrometry-to-immunohistochemistry translation step, assessing 2 independent validation sets, reveals 6 kinases with preserved independent prognostic value. The kinases split the validation set into two patterns: one without hyperactive kinases being associated with a >90% relapse-free rate, and the other one showing ≥1 hyperactive kinase and being associated with an up to 9.5-fold higher relapse risk. Each kinase pattern encompasses different mutational patterns, simplifying mutation-based taxonomy. Drug regimens designed based on these 6 kinases show promising antitumour activity in TNBC cell lines and patient-derived xenografts. In summary, the present study elucidates phosphosites and kinases implicated in TNBC and suggests a target-based clinical classification system for TNBC.";
        //abstracts[2] = "Nitrogen containing bisphosphonates such as zoledronic acid (ZA) are known to contain certain anti-cancer properties. These have been investigated in the past in various cancers such as breast, prostate and colon. ZA in particular has shown promising results in pre-clinical studies. We propose a multicentre double-blind randomised controlled feasibility study to assess the recruitment and acceptability of ZA/placebo alongside chemotherapy in malignant pleural mesothelioma (MPM). Patients will be recruited for a 13-month period from October 2016 to November 2017. Eligible patients will be identified via the regional mesothelioma multidisciplinary team meeting. Those who receive chemotherapy will be randomised to receive either ZA or placebo alongside their chemotherapy. Those who decline chemotherapy will be offered to join the trial on the non-randomised open-labelled arm of the trial. Patients will receive a maximum of six cycles of ZA/placebo, at three-weekly cycles.All patients will be followed up for six months from randomisation. Semi-structured interviews to gather data on acceptability of trial procedures, tolerability of ZA and other relevant information will take place after the participants have completed their six cycles of treatment. For a better understanding about non-participation in mesothelioma trials we also aim to interview those who decline to take part in the trial.The qualitative and quantitative data gathered in this feasibility trial will hopefully pave the way to designing a robust full phase III trial to investigate the potential synergistic effect of ZA and current standard treatment for MPM, cisplatin-pemetrexed combination chemotherapy.";
        //abstracts[3] = "Estrogen receptor-α (ER-α), encoded by ESR1, is detected by immunohistochemistry in approximately 70% of invasive breast cancers and serves as a strong predictive biomarker. ESR1-activating mutations in the ligand-binding domain have been reported in up to 35-40% of ER-positive metastatic breast cancers and are associated with endocrine therapy resistance and disease progression. At present, it is unclear whether ESR1 mutations alter the immunohistochemical detection of ER performed in routine clinical practice. In this study, ESR1 mutations in breast cancer were identified utilizing Memorial Sloan Kettering-Integrated Mutation Profiling of Actionable Cancer Targets (MSK-IMPACT), a Food and Drug Administration-approved hybridization capture-based next-generation sequencing assay. Five hundred and eighty-six breast cancers from patients with locally advanced or metastatic disease were analyzed using MSK-IMPACT in the study period. ESR1 somatic alterations were identified in 67 breast cancer samples from 66 patients. Immunohistochemical analysis of ER, progesterone receptor, and human epidermal growth factor receptor 2 was performed on the primary and treated breast cancers from these patients at the time of diagnosis. Twenty unique ESR1 mutations were identified involving the ligand-binding domain, all in breast cancer samples from patients previously treated with endocrine therapy. The most frequent mutations were D538G (n = 22), Y537S (n = 7), and E380Q (n = 7). All breast cancer samples with an ESR1 mutation were ER-positive by immunohistochemistry. Review of the ER immunohistochemistry in the paired untreated primary tumor and treated tumor from 34 patients showed no detectable change in the ER-positive immunohistochemical status (median percentage of invasive tumor cells with nuclear staining: untreated primary tumor 90%, treated tumor 95%). We conclude that ESR1 mutations do not appreciably diminish ER-positive staining by immunohistochemistry. In addition to standard biomarker testing by immunohistochemistry, the assessment of ESR1 mutations by molecular testing can help guide the clinical management of patients with ER-positive breast cancer in the setting of endocrine resistance and progression of disease.";
        //abstracts[4] = "The mechanisms underlying cognitive decline after radiotherapy not directed at brain areas remains unclear. We previously suggested that adjuvant breast radiotherapy in breast conservation therapy could lower memory function soon after therapy, and that the process might be partially mediated by plasma interleukin (IL)-6 levels. The present study investigated how that relationship changes longitudinally. We performed the Wechsler Memory Scale-Revised (WMS-R) test and measured plasma IL-6 levels for 47 breast cancer surgical patients within 1 year after the initial therapy (study 1) and more than 2 years after study 1 (study 2). We also performed 2 × 2 mixed [the radiotherapy group (n = 25) or the no-radiotherapy group (n = 22) × study 1 or study 2] analysis of covariance on the WMS-R indices and plasma IL-6 levels. The association between changes in plasma IL-6 levels and changes in the WMS-R indices between the two studies was evaluated using Pearson's correlation coefficient. The Immediate Verbal Memory Index was significantly higher in study 2. The Delayed Recall Index was significantly higher in study 2 and significantly lower in the radiotherapy group only in study 1. There was a significant correlation between changes in plasma IL-6 levels and changes only in the Delayed Recall Index of the WMS-R. Memory decline in breast cancer patients soon after adjuvant breast radiotherapy was restored approximately 3 years after treatment, and decreased plasma IL-6 levels might be involved in the recovery process.";
        //abstracts[5] = "To describe the mortality experience of women who die of breast cancer in the 20-year period post-diagnosis using various metrics, including annual mortality rates, Kaplan-Meier survival curves and time-to-death histograms. We generated three visual representations of SEER-based and hospital-based breast cancer patient cohorts using three different metrics of mortality. The greatest impact of most prognostic factors was on the probability of latent metastases present after treatment, but for some factors the primary impact was on the time to death for those women with metastases. The use of time-to-death statistics to display mortality benefits for treated versus untreated women helps facilitate the distinction between treatments which increase the likelihood of cure and treatments that delay cancer growth.";
        //abstracts[6] = "Basal-like breast cancer is an aggressive form of breast cancer with limited treatment options. The subgroup can be identified immunohistochemically, by lack of hormone receptor expression combined with expression of basal markers such as CK5/6 and/or epidermal growth factor receptor (EGFR). In vitro, several regulators of the actin cytoskeleton are essential for efficient invasion of basal-like breast cancer cell lines. Whether these proteins are expressed in vivo determines the applicability of these findings in clinical settings. The actin-regulating formin protein FHOD1 participates in invasion of the triple-negative breast cancer cell line MDA-MB-231. Here, we measure the expression of FHOD1 protein in clinical triple-negative breast cancers by using immunohistochemistry and further characterize the expression of another formin protein, INF2. We report that basal-like breast cancers frequently overexpress formin proteins FHOD1 and INF2. In cell studies using basal-like breast cancer cell lines, we show that knockdown of FHOD1 or INF2 interferes with very similar processes: maintenance of cell shape, migration, invasion, and proliferation. Inhibition of EGFR, PI3K, or mitogen-activated protein kinase activity does not alter the expression of FHOD1 and INF2 in these cell lines. We conclude that the experimental studies on these formins have implications in the clinical behavior of basal-like breast cancer.";
        //abstracts[7] = "Although eribulin mesylate(ERI)has been approved for metastatic breast cancer, its efficacy and safety in combination with other chemotherapeutic agents have not been established. To investigate the tolerability of combination therapy with ERI and gemcitabine(GEM), we conducted a phase I clinical study in Japanese patients with metastatic breast cancer. The initial doses(Level 0)of ERI and GEM were 1.1mg/m2 and 800 mg/m2, respectively. When tolerability to Level 0 doses was confirmed, the doses were escalated to 1.4mg/m2 for ERI and 800 mg/m2 for GEM(Level 1). Seven patients were enrolled in this study; 3 patients received Level 0 doses and the other 4 patients received Level 1 doses. A dose limiting toxicity(DLT)was found in only 1 patient of the Level 1 group(Grade 3 oral mucositis). However, Grade 3 or higher hematological toxicities, including neutropenia, frequently occurred, and hence, this combination therapy was not conducted as scheduled. Thus, maximum tolerated dose(MTD)and recommended dose(RD)for phase II trials were not evaluated in this study. Drugdrug interactions between ERI and GEM were not observed. In conclusion, it was difficult to continue the combination therapy for patients with advanced recurrent breast cancer due to hematological toxicities. There is little possibility for the combination therapy with ERI and GEM at the specific doses to be regarded as a new treatment option for Japanese patients.";
        //abstracts[8] = "Circular RNAs (circRNAs) are a type of noncoding RNAs with a closed loop structure. With the development of high-throughput sequencing, massive circRNAs have been discovered in tumorous tissues. Emerging evidence suggests that the biological functions of circRNAs including serving as ceRNAs or miRNA sponges, interacting with proteins, regulating gene transcription and translation, suggesting that circRNAs will be novel biomarkers and targets for the diagnosis and prognosis of diseases. Breast cancer is the most frequently occurring cancer and the leading cause of cancer-related death among women worldwide. It is vital to understand the molecular pathways involved in the pathogenesis of proliferation and progression. In this review, we summarize the current knowledge on human circRNAs and their potential clinical implications on breast cancer.";
        //abstracts[0] = "Breast cancer and its treatment can have many physical and psychological effects on affected women. Women's personal goals may provide insight into their priorities and motivations in the context of breast cancer. Incorporating personal goal-setting into support and care interventions may have an effect on psychological well-being. This protocol describes our scoping review methods, the aim of which is to examine and map the existing evidence on personal goal-setting among women with a breast cancer diagnosis. Our scoping review will search for published, full-length articles, where personal goal-setting is a major component of the study, and the study population is females with breast cancer. MEDLINE, PsycInfo, CINAHL, EMBASE, the Cochrane Library, and AMED databases will be searched. Two independent reviewers will conduct all screening and extract data. Descriptive information about the studies, participants, any interventions, measurement tools, outcomes, and results will be reported. The results from this review will chart the literature, contributing to optimizing the incorporation of personal goal-setting approaches into effective interventions for the care and support of women with breast cancer";
        // creates a StanfordCoreNLP object, with POS tagging, lemmatization, NER, parsing, and coreference resolution

        Properties props = new Properties();
        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
        int i=1;
        for (String s: abstracts) {

            //Clearning vars
            Set<String> nounsList = new HashSet<String>();
            Set<String> verbsList = new HashSet<String>();
            Set<String> nersList = new HashSet<String>();
            int wordCount=0;
            System.out.println(("Processing File "+ i));
            i=i+1;
// read some text in the text variable
            String text = s;


// create an empty Annotation just with the given text
            Annotation document = new Annotation(text);

// run all Annotators on this text
            pipeline.annotate(document);

            // these are all the sentences in this document
// a CoreMap is essentially a Map that uses class objects as keys and has values with custom types
            List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);

            for (CoreMap sentence : sentences) {
                // traversing the words in the current sentence
                // a CoreLabel is a CoreMap with additional token-specific methods
                for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {

                    //System.out.println("\n" + token);
                    //wordCount=wordCount + 1;
                    // this is the text of the token
                    String word = token.get(CoreAnnotations.TextAnnotation.class);
                    // System.out.println("Text Annotation");
                    // System.out.println(token + ":" + word);
                    // this is the POS tag of the token

                    String lemma = token.get(CoreAnnotations.LemmaAnnotation.class);
                    //System.out.println("Lemma Annotation");
                    //System.out.println(token + ":" + lemma);
                    // this is the Lemmatized tag of the token


                    String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                    //System.out.println("POS");
                    //System.out.println(token + ":" + pos);
                    if (pos.contains("NN")) {
                        nounsList.add(word);

                    } else if (pos.contains(("VB"))) {
                        verbsList.add(word);
                    }
                    if(pos.length() > 1)
                    {
                        System.out.println("Word: " +word + " " +pos);
                        wordCount=wordCount + 1;
                    }

                    // this is the NER label of the token
                    String ne = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);
                    // System.out.println("NER");
                    //System.out.println(token + ":" + ne);
                    if (ne.length() > 1) {
                        nersList.add(word + "-" + ne);
                    }
                }

                // this is the parse tree of the current sentence
                Tree tree = sentence.get(TreeCoreAnnotations.TreeAnnotation.class);
                // System.out.println(tree);
                // this is the Stanford dependency graph of the current sentence


                Map<Integer, CorefChain> graph =
                        document.get(CorefCoreAnnotations.CorefChainAnnotation.class);
                //System.out.println(graph.values().toString());
            }
            System.out.println("POS : Noun:" + nounsList.size());
            System.out.println("POS: Verb:" + verbsList.size());
            System.out.println("NER : Name:" + nersList.size());

            System.out.println("POS : Nouns:" + StringUtils.join(nounsList, ','));
            System.out.println("POS: Verb:" + StringUtils.join(verbsList, ','));
            System.out.println("NER : Name:" + StringUtils.join(nersList, ','));
            System.out.println("Total Word:" + wordCount);
        }
    }
}
