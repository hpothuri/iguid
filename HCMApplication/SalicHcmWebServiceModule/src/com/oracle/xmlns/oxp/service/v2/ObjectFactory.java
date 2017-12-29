
package com.oracle.xmlns.oxp.service.v2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.oracle.xmlns.oxp.service.v2 package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Fault_QNAME = new QName("http://xmlns.oracle.com/oxp/service/v2", "fault");
    private final static QName _Fault1_QNAME = new QName("http://xmlns.oracle.com/oxp/service/v2", "fault1");
    private final static QName _Fault2_QNAME = new QName("http://xmlns.oracle.com/oxp/service/v2", "fault2");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.xmlns.oxp.service.v2
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetDocumentData }
     *
     */
    public GetDocumentData createGetDocumentData() {
        return new GetDocumentData();
    }

    /**
     * Create an instance of {@link GetDocumentDataResponse }
     *
     */
    public GetDocumentDataResponse createGetDocumentDataResponse() {
        return new GetDocumentDataResponse();
    }

    /**
     * Create an instance of {@link GetAllJobInstanceIDs }
     *
     */
    public GetAllJobInstanceIDs createGetAllJobInstanceIDs() {
        return new GetAllJobInstanceIDs();
    }

    /**
     * Create an instance of {@link GetAllJobInstanceIDsResponse }
     *
     */
    public GetAllJobInstanceIDsResponse createGetAllJobInstanceIDsResponse() {
        return new GetAllJobInstanceIDsResponse();
    }

    /**
     * Create an instance of {@link ArrayOfString }
     *
     */
    public ArrayOfString createArrayOfString() {
        return new ArrayOfString();
    }

    /**
     * Create an instance of {@link AccessDeniedException }
     *
     */
    public AccessDeniedException createAccessDeniedException() {
        return new AccessDeniedException();
    }

    /**
     * Create an instance of {@link InvalidParametersException }
     *
     */
    public InvalidParametersException createInvalidParametersException() {
        return new InvalidParametersException();
    }

    /**
     * Create an instance of {@link OperationFailedException }
     *
     */
    public OperationFailedException createOperationFailedException() {
        return new OperationFailedException();
    }

    /**
     * Create an instance of {@link GetAllScheduledReport }
     *
     */
    public GetAllScheduledReport createGetAllScheduledReport() {
        return new GetAllScheduledReport();
    }

    /**
     * Create an instance of {@link JobFilterProperties }
     *
     */
    public JobFilterProperties createJobFilterProperties() {
        return new JobFilterProperties();
    }

    /**
     * Create an instance of {@link GetAllScheduledReportResponse }
     *
     */
    public GetAllScheduledReportResponse createGetAllScheduledReportResponse() {
        return new GetAllScheduledReportResponse();
    }

    /**
     * Create an instance of {@link JobInfosList }
     *
     */
    public JobInfosList createJobInfosList() {
        return new JobInfosList();
    }

    /**
     * Create an instance of {@link GetAllScheduledReportInSession }
     *
     */
    public GetAllScheduledReportInSession createGetAllScheduledReportInSession() {
        return new GetAllScheduledReportInSession();
    }

    /**
     * Create an instance of {@link GetAllScheduledReportInSessionResponse }
     *
     */
    public GetAllScheduledReportInSessionResponse createGetAllScheduledReportInSessionResponse() {
        return new GetAllScheduledReportInSessionResponse();
    }

    /**
     * Create an instance of {@link GetScheduledJobInfo }
     *
     */
    public GetScheduledJobInfo createGetScheduledJobInfo() {
        return new GetScheduledJobInfo();
    }

    /**
     * Create an instance of {@link GetScheduledJobInfoResponse }
     *
     */
    public GetScheduledJobInfoResponse createGetScheduledJobInfoResponse() {
        return new GetScheduledJobInfoResponse();
    }

    /**
     * Create an instance of {@link JobDetail }
     *
     */
    public JobDetail createJobDetail() {
        return new JobDetail();
    }

    /**
     * Create an instance of {@link GetScheduledJobInfoInSession }
     *
     */
    public GetScheduledJobInfoInSession createGetScheduledJobInfoInSession() {
        return new GetScheduledJobInfoInSession();
    }

    /**
     * Create an instance of {@link GetScheduledJobInfoInSessionResponse }
     *
     */
    public GetScheduledJobInfoInSessionResponse createGetScheduledJobInfoInSessionResponse() {
        return new GetScheduledJobInfoInSessionResponse();
    }

    /**
     * Create an instance of {@link GetScheduledReportStatus }
     *
     */
    public GetScheduledReportStatus createGetScheduledReportStatus() {
        return new GetScheduledReportStatus();
    }

    /**
     * Create an instance of {@link GetScheduledReportStatusResponse }
     *
     */
    public GetScheduledReportStatusResponse createGetScheduledReportStatusResponse() {
        return new GetScheduledReportStatusResponse();
    }

    /**
     * Create an instance of {@link JobStatus }
     *
     */
    public JobStatus createJobStatus() {
        return new JobStatus();
    }

    /**
     * Create an instance of {@link GetScheduledReportStatusInSession }
     *
     */
    public GetScheduledReportStatusInSession createGetScheduledReportStatusInSession() {
        return new GetScheduledReportStatusInSession();
    }

    /**
     * Create an instance of {@link GetScheduledReportStatusInSessionResponse }
     *
     */
    public GetScheduledReportStatusInSessionResponse createGetScheduledReportStatusInSessionResponse() {
        return new GetScheduledReportStatusInSessionResponse();
    }

    /**
     * Create an instance of {@link GetAllScheduledReportHistory }
     *
     */
    public GetAllScheduledReportHistory createGetAllScheduledReportHistory() {
        return new GetAllScheduledReportHistory();
    }

    /**
     * Create an instance of {@link GetAllScheduledReportHistoryResponse }
     *
     */
    public GetAllScheduledReportHistoryResponse createGetAllScheduledReportHistoryResponse() {
        return new GetAllScheduledReportHistoryResponse();
    }

    /**
     * Create an instance of {@link GetAllScheduledReportHistoryInSession }
     *
     */
    public GetAllScheduledReportHistoryInSession createGetAllScheduledReportHistoryInSession() {
        return new GetAllScheduledReportHistoryInSession();
    }

    /**
     * Create an instance of {@link GetAllScheduledReportHistoryInSessionResponse }
     *
     */
    public GetAllScheduledReportHistoryInSessionResponse createGetAllScheduledReportHistoryInSessionResponse() {
        return new GetAllScheduledReportHistoryInSessionResponse();
    }

    /**
     * Create an instance of {@link GetScheduledReportOutputInfo }
     *
     */
    public GetScheduledReportOutputInfo createGetScheduledReportOutputInfo() {
        return new GetScheduledReportOutputInfo();
    }

    /**
     * Create an instance of {@link GetScheduledReportOutputInfoResponse }
     *
     */
    public GetScheduledReportOutputInfoResponse createGetScheduledReportOutputInfoResponse() {
        return new GetScheduledReportOutputInfoResponse();
    }

    /**
     * Create an instance of {@link JobOutputsList }
     *
     */
    public JobOutputsList createJobOutputsList() {
        return new JobOutputsList();
    }

    /**
     * Create an instance of {@link GetScheduledReportOutputInfoInSession }
     *
     */
    public GetScheduledReportOutputInfoInSession createGetScheduledReportOutputInfoInSession() {
        return new GetScheduledReportOutputInfoInSession();
    }

    /**
     * Create an instance of {@link GetScheduledReportOutputInfoInSessionResponse }
     *
     */
    public GetScheduledReportOutputInfoInSessionResponse createGetScheduledReportOutputInfoInSessionResponse() {
        return new GetScheduledReportOutputInfoInSessionResponse();
    }

    /**
     * Create an instance of {@link GetDocumentDataInSession }
     *
     */
    public GetDocumentDataInSession createGetDocumentDataInSession() {
        return new GetDocumentDataInSession();
    }

    /**
     * Create an instance of {@link GetDocumentDataInSessionResponse }
     *
     */
    public GetDocumentDataInSessionResponse createGetDocumentDataInSessionResponse() {
        return new GetDocumentDataInSessionResponse();
    }

    /**
     * Create an instance of {@link DownloadDocumentData }
     *
     */
    public DownloadDocumentData createDownloadDocumentData() {
        return new DownloadDocumentData();
    }

    /**
     * Create an instance of {@link DownloadDocumentDataResponse }
     *
     */
    public DownloadDocumentDataResponse createDownloadDocumentDataResponse() {
        return new DownloadDocumentDataResponse();
    }

    /**
     * Create an instance of {@link DownloadDocumentDataInSession }
     *
     */
    public DownloadDocumentDataInSession createDownloadDocumentDataInSession() {
        return new DownloadDocumentDataInSession();
    }

    /**
     * Create an instance of {@link DownloadDocumentDataInSessionResponse }
     *
     */
    public DownloadDocumentDataInSessionResponse createDownloadDocumentDataInSessionResponse() {
        return new DownloadDocumentDataInSessionResponse();
    }

    /**
     * Create an instance of {@link GetXMLData }
     *
     */
    public GetXMLData createGetXMLData() {
        return new GetXMLData();
    }

    /**
     * Create an instance of {@link GetXMLDataResponse }
     *
     */
    public GetXMLDataResponse createGetXMLDataResponse() {
        return new GetXMLDataResponse();
    }

    /**
     * Create an instance of {@link GetXMLDataInSession }
     *
     */
    public GetXMLDataInSession createGetXMLDataInSession() {
        return new GetXMLDataInSession();
    }

    /**
     * Create an instance of {@link GetXMLDataInSessionResponse }
     *
     */
    public GetXMLDataInSessionResponse createGetXMLDataInSessionResponse() {
        return new GetXMLDataInSessionResponse();
    }

    /**
     * Create an instance of {@link DownloadXMLData }
     *
     */
    public DownloadXMLData createDownloadXMLData() {
        return new DownloadXMLData();
    }

    /**
     * Create an instance of {@link DownloadXMLDataResponse }
     *
     */
    public DownloadXMLDataResponse createDownloadXMLDataResponse() {
        return new DownloadXMLDataResponse();
    }

    /**
     * Create an instance of {@link DownloadXMLDataInSession }
     *
     */
    public DownloadXMLDataInSession createDownloadXMLDataInSession() {
        return new DownloadXMLDataInSession();
    }

    /**
     * Create an instance of {@link DownloadXMLDataInSessionResponse }
     *
     */
    public DownloadXMLDataInSessionResponse createDownloadXMLDataInSessionResponse() {
        return new DownloadXMLDataInSessionResponse();
    }

    /**
     * Create an instance of {@link ResendScheduledReport }
     *
     */
    public ResendScheduledReport createResendScheduledReport() {
        return new ResendScheduledReport();
    }

    /**
     * Create an instance of {@link ResendScheduledReportResponse }
     *
     */
    public ResendScheduledReportResponse createResendScheduledReportResponse() {
        return new ResendScheduledReportResponse();
    }

    /**
     * Create an instance of {@link ResendScheduledReportInSession }
     *
     */
    public ResendScheduledReportInSession createResendScheduledReportInSession() {
        return new ResendScheduledReportInSession();
    }

    /**
     * Create an instance of {@link ResendScheduledReportInSessionResponse }
     *
     */
    public ResendScheduledReportInSessionResponse createResendScheduledReportInSessionResponse() {
        return new ResendScheduledReportInSessionResponse();
    }

    /**
     * Create an instance of {@link DeleteJobHistory }
     *
     */
    public DeleteJobHistory createDeleteJobHistory() {
        return new DeleteJobHistory();
    }

    /**
     * Create an instance of {@link DeleteJobHistoryResponse }
     *
     */
    public DeleteJobHistoryResponse createDeleteJobHistoryResponse() {
        return new DeleteJobHistoryResponse();
    }

    /**
     * Create an instance of {@link DeleteJobHistoryInSession }
     *
     */
    public DeleteJobHistoryInSession createDeleteJobHistoryInSession() {
        return new DeleteJobHistoryInSession();
    }

    /**
     * Create an instance of {@link DeleteJobHistoryInSessionResponse }
     *
     */
    public DeleteJobHistoryInSessionResponse createDeleteJobHistoryInSessionResponse() {
        return new DeleteJobHistoryInSessionResponse();
    }

    /**
     * Create an instance of {@link PurgeJobHistory }
     *
     */
    public PurgeJobHistory createPurgeJobHistory() {
        return new PurgeJobHistory();
    }

    /**
     * Create an instance of {@link PurgeJobHistoryResponse }
     *
     */
    public PurgeJobHistoryResponse createPurgeJobHistoryResponse() {
        return new PurgeJobHistoryResponse();
    }

    /**
     * Create an instance of {@link PurgeJobHistoryInSession }
     *
     */
    public PurgeJobHistoryInSession createPurgeJobHistoryInSession() {
        return new PurgeJobHistoryInSession();
    }

    /**
     * Create an instance of {@link PurgeJobHistoryInSessionResponse }
     *
     */
    public PurgeJobHistoryInSessionResponse createPurgeJobHistoryInSessionResponse() {
        return new PurgeJobHistoryInSessionResponse();
    }

    /**
     * Create an instance of {@link GetScheduledReportDeliveryInfo }
     *
     */
    public GetScheduledReportDeliveryInfo createGetScheduledReportDeliveryInfo() {
        return new GetScheduledReportDeliveryInfo();
    }

    /**
     * Create an instance of {@link GetScheduledReportDeliveryInfoResponse }
     *
     */
    public GetScheduledReportDeliveryInfoResponse createGetScheduledReportDeliveryInfoResponse() {
        return new GetScheduledReportDeliveryInfoResponse();
    }

    /**
     * Create an instance of {@link JobOutputDeliverysList }
     *
     */
    public JobOutputDeliverysList createJobOutputDeliverysList() {
        return new JobOutputDeliverysList();
    }

    /**
     * Create an instance of {@link GetScheduledReportDeliveryInfoInSession }
     *
     */
    public GetScheduledReportDeliveryInfoInSession createGetScheduledReportDeliveryInfoInSession() {
        return new GetScheduledReportDeliveryInfoInSession();
    }

    /**
     * Create an instance of {@link GetScheduledReportDeliveryInfoInSessionResponse }
     *
     */
    public GetScheduledReportDeliveryInfoInSessionResponse createGetScheduledReportDeliveryInfoInSessionResponse() {
        return new GetScheduledReportDeliveryInfoInSessionResponse();
    }

    /**
     * Create an instance of {@link ScheduleReport }
     *
     */
    public ScheduleReport createScheduleReport() {
        return new ScheduleReport();
    }

    /**
     * Create an instance of {@link ScheduleRequest }
     *
     */
    public ScheduleRequest createScheduleRequest() {
        return new ScheduleRequest();
    }

    /**
     * Create an instance of {@link ScheduleReportResponse }
     *
     */
    public ScheduleReportResponse createScheduleReportResponse() {
        return new ScheduleReportResponse();
    }

    /**
     * Create an instance of {@link ScheduleReportInSession }
     *
     */
    public ScheduleReportInSession createScheduleReportInSession() {
        return new ScheduleReportInSession();
    }

    /**
     * Create an instance of {@link DeliveryChannels }
     *
     */
    public DeliveryChannels createDeliveryChannels() {
        return new DeliveryChannels();
    }

    /**
     * Create an instance of {@link ScheduleReportInSessionResponse }
     *
     */
    public ScheduleReportInSessionResponse createScheduleReportInSessionResponse() {
        return new ScheduleReportInSessionResponse();
    }

    /**
     * Create an instance of {@link DeleteSchedule }
     *
     */
    public DeleteSchedule createDeleteSchedule() {
        return new DeleteSchedule();
    }

    /**
     * Create an instance of {@link DeleteScheduleResponse }
     *
     */
    public DeleteScheduleResponse createDeleteScheduleResponse() {
        return new DeleteScheduleResponse();
    }

    /**
     * Create an instance of {@link DeleteScheduleInSession }
     *
     */
    public DeleteScheduleInSession createDeleteScheduleInSession() {
        return new DeleteScheduleInSession();
    }

    /**
     * Create an instance of {@link DeleteScheduleInSessionResponse }
     *
     */
    public DeleteScheduleInSessionResponse createDeleteScheduleInSessionResponse() {
        return new DeleteScheduleInSessionResponse();
    }

    /**
     * Create an instance of {@link ResumeSchedule }
     *
     */
    public ResumeSchedule createResumeSchedule() {
        return new ResumeSchedule();
    }

    /**
     * Create an instance of {@link ResumeScheduleResponse }
     *
     */
    public ResumeScheduleResponse createResumeScheduleResponse() {
        return new ResumeScheduleResponse();
    }

    /**
     * Create an instance of {@link ResumeScheduleInSession }
     *
     */
    public ResumeScheduleInSession createResumeScheduleInSession() {
        return new ResumeScheduleInSession();
    }

    /**
     * Create an instance of {@link ResumeScheduleInSessionResponse }
     *
     */
    public ResumeScheduleInSessionResponse createResumeScheduleInSessionResponse() {
        return new ResumeScheduleInSessionResponse();
    }

    /**
     * Create an instance of {@link SuspendSchedule }
     *
     */
    public SuspendSchedule createSuspendSchedule() {
        return new SuspendSchedule();
    }

    /**
     * Create an instance of {@link SuspendScheduleResponse }
     *
     */
    public SuspendScheduleResponse createSuspendScheduleResponse() {
        return new SuspendScheduleResponse();
    }

    /**
     * Create an instance of {@link SuspendScheduleInSession }
     *
     */
    public SuspendScheduleInSession createSuspendScheduleInSession() {
        return new SuspendScheduleInSession();
    }

    /**
     * Create an instance of {@link SuspendScheduleInSessionResponse }
     *
     */
    public SuspendScheduleInSessionResponse createSuspendScheduleInSessionResponse() {
        return new SuspendScheduleInSessionResponse();
    }

    /**
     * Create an instance of {@link CancelSchedule }
     *
     */
    public CancelSchedule createCancelSchedule() {
        return new CancelSchedule();
    }

    /**
     * Create an instance of {@link CancelScheduleResponse }
     *
     */
    public CancelScheduleResponse createCancelScheduleResponse() {
        return new CancelScheduleResponse();
    }

    /**
     * Create an instance of {@link CancelScheduleInSession }
     *
     */
    public CancelScheduleInSession createCancelScheduleInSession() {
        return new CancelScheduleInSession();
    }

    /**
     * Create an instance of {@link CancelScheduleInSessionResponse }
     *
     */
    public CancelScheduleInSessionResponse createCancelScheduleInSessionResponse() {
        return new CancelScheduleInSessionResponse();
    }

    /**
     * Create an instance of {@link GetDeliveryServiceDefinition }
     *
     */
    public GetDeliveryServiceDefinition createGetDeliveryServiceDefinition() {
        return new GetDeliveryServiceDefinition();
    }

    /**
     * Create an instance of {@link GetDeliveryServiceDefinitionResponse }
     *
     */
    public GetDeliveryServiceDefinitionResponse createGetDeliveryServiceDefinitionResponse() {
        return new GetDeliveryServiceDefinitionResponse();
    }

    /**
     * Create an instance of {@link DeliveryServiceDefinition }
     *
     */
    public DeliveryServiceDefinition createDeliveryServiceDefinition() {
        return new DeliveryServiceDefinition();
    }

    /**
     * Create an instance of {@link GetDeliveryServiceDefinitionInSession }
     *
     */
    public GetDeliveryServiceDefinitionInSession createGetDeliveryServiceDefinitionInSession() {
        return new GetDeliveryServiceDefinitionInSession();
    }

    /**
     * Create an instance of {@link GetDeliveryServiceDefinitionInSessionResponse }
     *
     */
    public GetDeliveryServiceDefinitionInSessionResponse createGetDeliveryServiceDefinitionInSessionResponse() {
        return new GetDeliveryServiceDefinitionInSessionResponse();
    }

    /**
     * Create an instance of {@link DeliveryService }
     *
     */
    public DeliveryService createDeliveryService() {
        return new DeliveryService();
    }

    /**
     * Create an instance of {@link DeliveryRequest }
     *
     */
    public DeliveryRequest createDeliveryRequest() {
        return new DeliveryRequest();
    }

    /**
     * Create an instance of {@link DeliveryServiceResponse }
     *
     */
    public DeliveryServiceResponse createDeliveryServiceResponse() {
        return new DeliveryServiceResponse();
    }

    /**
     * Create an instance of {@link DeliveryServiceInSession }
     *
     */
    public DeliveryServiceInSession createDeliveryServiceInSession() {
        return new DeliveryServiceInSession();
    }

    /**
     * Create an instance of {@link DeliveryServiceInSessionResponse }
     *
     */
    public DeliveryServiceInSessionResponse createDeliveryServiceInSessionResponse() {
        return new DeliveryServiceInSessionResponse();
    }

    /**
     * Create an instance of {@link JobInfo }
     *
     */
    public JobInfo createJobInfo() {
        return new JobInfo();
    }

    /**
     * Create an instance of {@link ArrayOfJobInfo }
     *
     */
    public ArrayOfJobInfo createArrayOfJobInfo() {
        return new ArrayOfJobInfo();
    }

    /**
     * Create an instance of {@link JobOutput }
     *
     */
    public JobOutput createJobOutput() {
        return new JobOutput();
    }

    /**
     * Create an instance of {@link ArrayOfJobOutput }
     *
     */
    public ArrayOfJobOutput createArrayOfJobOutput() {
        return new ArrayOfJobOutput();
    }

    /**
     * Create an instance of {@link JobOutputDelivery }
     *
     */
    public JobOutputDelivery createJobOutputDelivery() {
        return new JobOutputDelivery();
    }

    /**
     * Create an instance of {@link ArrayOfJobOutputDelivery }
     *
     */
    public ArrayOfJobOutputDelivery createArrayOfJobOutputDelivery() {
        return new ArrayOfJobOutputDelivery();
    }

    /**
     * Create an instance of {@link EMailDeliveryOption }
     *
     */
    public EMailDeliveryOption createEMailDeliveryOption() {
        return new EMailDeliveryOption();
    }

    /**
     * Create an instance of {@link ArrayOfEMailDeliveryOption }
     *
     */
    public ArrayOfEMailDeliveryOption createArrayOfEMailDeliveryOption() {
        return new ArrayOfEMailDeliveryOption();
    }

    /**
     * Create an instance of {@link FaxDeliveryOption }
     *
     */
    public FaxDeliveryOption createFaxDeliveryOption() {
        return new FaxDeliveryOption();
    }

    /**
     * Create an instance of {@link ArrayOfFaxDeliveryOption }
     *
     */
    public ArrayOfFaxDeliveryOption createArrayOfFaxDeliveryOption() {
        return new ArrayOfFaxDeliveryOption();
    }

    /**
     * Create an instance of {@link FTPDeliveryOption }
     *
     */
    public FTPDeliveryOption createFTPDeliveryOption() {
        return new FTPDeliveryOption();
    }

    /**
     * Create an instance of {@link ArrayOfFTPDeliveryOption }
     *
     */
    public ArrayOfFTPDeliveryOption createArrayOfFTPDeliveryOption() {
        return new ArrayOfFTPDeliveryOption();
    }

    /**
     * Create an instance of {@link LocalDeliveryOption }
     *
     */
    public LocalDeliveryOption createLocalDeliveryOption() {
        return new LocalDeliveryOption();
    }

    /**
     * Create an instance of {@link ArrayOfLocalDeliveryOption }
     *
     */
    public ArrayOfLocalDeliveryOption createArrayOfLocalDeliveryOption() {
        return new ArrayOfLocalDeliveryOption();
    }

    /**
     * Create an instance of {@link PrintDeliveryOption }
     *
     */
    public PrintDeliveryOption createPrintDeliveryOption() {
        return new PrintDeliveryOption();
    }

    /**
     * Create an instance of {@link ArrayOfPrintDeliveryOption }
     *
     */
    public ArrayOfPrintDeliveryOption createArrayOfPrintDeliveryOption() {
        return new ArrayOfPrintDeliveryOption();
    }

    /**
     * Create an instance of {@link WCCDeliveryOption }
     *
     */
    public WCCDeliveryOption createWCCDeliveryOption() {
        return new WCCDeliveryOption();
    }

    /**
     * Create an instance of {@link ArrayOfWCCDeliveryOption }
     *
     */
    public ArrayOfWCCDeliveryOption createArrayOfWCCDeliveryOption() {
        return new ArrayOfWCCDeliveryOption();
    }

    /**
     * Create an instance of {@link WebDAVDeliveryOption }
     *
     */
    public WebDAVDeliveryOption createWebDAVDeliveryOption() {
        return new WebDAVDeliveryOption();
    }

    /**
     * Create an instance of {@link ArrayOfWebDAVDeliveryOption }
     *
     */
    public ArrayOfWebDAVDeliveryOption createArrayOfWebDAVDeliveryOption() {
        return new ArrayOfWebDAVDeliveryOption();
    }

    /**
     * Create an instance of {@link MetaData }
     *
     */
    public MetaData createMetaData() {
        return new MetaData();
    }

    /**
     * Create an instance of {@link ArrayOfMetaData }
     *
     */
    public ArrayOfMetaData createArrayOfMetaData() {
        return new ArrayOfMetaData();
    }

    /**
     * Create an instance of {@link MetaDataList }
     *
     */
    public MetaDataList createMetaDataList() {
        return new MetaDataList();
    }

    /**
     * Create an instance of {@link JDBCDataSource }
     *
     */
    public JDBCDataSource createJDBCDataSource() {
        return new JDBCDataSource();
    }

    /**
     * Create an instance of {@link FileDataSource }
     *
     */
    public FileDataSource createFileDataSource() {
        return new FileDataSource();
    }

    /**
     * Create an instance of {@link BIPDataSource }
     *
     */
    public BIPDataSource createBIPDataSource() {
        return new BIPDataSource();
    }

    /**
     * Create an instance of {@link ParamNameValue }
     *
     */
    public ParamNameValue createParamNameValue() {
        return new ParamNameValue();
    }

    /**
     * Create an instance of {@link ArrayOfParamNameValue }
     *
     */
    public ArrayOfParamNameValue createArrayOfParamNameValue() {
        return new ArrayOfParamNameValue();
    }

    /**
     * Create an instance of {@link ParamNameValues }
     *
     */
    public ParamNameValues createParamNameValues() {
        return new ParamNameValues();
    }

    /**
     * Create an instance of {@link ReportRequest }
     *
     */
    public ReportRequest createReportRequest() {
        return new ReportRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccessDeniedException }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/oxp/service/v2", name = "fault")
    public JAXBElement<AccessDeniedException> createFault(AccessDeniedException value) {
        return new JAXBElement<AccessDeniedException>(_Fault_QNAME, AccessDeniedException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidParametersException }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/oxp/service/v2", name = "fault1")
    public JAXBElement<InvalidParametersException> createFault1(InvalidParametersException value) {
        return new JAXBElement<InvalidParametersException>(_Fault1_QNAME, InvalidParametersException.class, null,
                                                           value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperationFailedException }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://xmlns.oracle.com/oxp/service/v2", name = "fault2")
    public JAXBElement<OperationFailedException> createFault2(OperationFailedException value) {
        return new JAXBElement<OperationFailedException>(_Fault2_QNAME, OperationFailedException.class, null, value);
    }

}
