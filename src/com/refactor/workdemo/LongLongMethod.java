package com.refactor.workdemo;

/**
 * @author songyi
 * @date 2021-02-07 17:26
 * @Description:
 */
public class LongLongMethod {


    /** ������ĵķ���
     * private List<FlowDetail.TaskNode> getFlowTask(AuditFlowProcessLog processLog) {
     *         String processId = String.valueOf(processLog.getProcessId());
     *         //task�������ˣ�δͨ���� ����ͨ���Ĳ�ͬ
     *         List<TaskLogExtend> auditFlowTaskLogs = getTask(processId);
     *         // ��������ڵ������漰������Ա�����������˺ͽڵ������ˣ�
     *         List<String> userMisIds = auditFlowTaskLogs.stream().map(t -> {
     *             List<String> taskAssignerList = new ArrayList<>();
     *             if (StringUtils.isNotBlank(t.getAuditAssignReq())) {
     *                 taskAssignerList.addAll(Arrays.asList(t.getAuditAssignReq().split(",")));
     *             }
     *             if (StringUtils.isNotBlank(t.getAuditAssign())) {
     *                 taskAssignerList.addAll(Arrays.asList(t.getAuditAssign().split(",")));
     *             }
     *             return taskAssignerList;
     *         }).flatMap(t -> t.stream()).distinct().collect(toList());
     *         userMisIds.add(processLog.getApplyUser());
     *         List<DimEmployeeBean> empInfoList = dimEmployeeService.getEmpInfoListByMisListContainsLeave(userMisIds);
     *         Map<String, DimEmployeeBean> superiorMap = empInfoList.stream().collect(Collectors.toMap(DimEmployeeBean::getMisName, dimEmployeeBean -> dimEmployeeBean));
     *
     *         List<FlowDetail.TaskNode> result = new ArrayList<>();
     *         Map<String, String> userAvatarUrl = rpcCommonQueryService.getUserAvatarUrlList(userMisIds);
     *         //��һ�����ύ����
     *         FlowDetail.TaskNode applyNode = new FlowDetail.TaskNode();
     *         applyNode.setStatus(3);
     *         applyNode.setModifyTime(CommonUtil.dateToYMDHMSString(auditFlowTaskLogs.get(0).getAuditStartTime()));
     *         List<FlowDetail.AssignerInfo> applyInfo = new ArrayList<>();
     *         DimEmployeeBean applyEmployee = superiorMap.get(processLog.getApplyUser());
     *         if (applyEmployee != null) {
     *             FlowDetail.AssignerInfo applyAssignerInfo = new FlowDetail.AssignerInfo();
     *             applyAssignerInfo.setAuditMis(processLog.getApplyUser());
     *             applyAssignerInfo.setAuditName(applyEmployee.getEmployeeName());
     *             applyAssignerInfo.setAvatarUrl(userAvatarUrl.get(processLog.getApplyUser()));
     *             applyInfo.add(applyAssignerInfo);
     *         }
     *         applyNode.setAssigners(applyInfo);
     *         applyNode.setTaskKey("apply");
     *         result.add(applyNode);
     *         int lastStatus = 3;
     *         for (TaskLogExtend taskLog : auditFlowTaskLogs) {
     *             FlowDetail.TaskNode taskNode = new FlowDetail.TaskNode();
     *             if (taskLog.getAddSign() > 0) {
     *                 //1��ʾ����ǩ
     *                 taskNode.setAddSign(1);
     *                 //��ǩ˵��
     *                 taskNode.setAddSignComment(taskLog.getAddComment());
     *             } else {
     *                 //0��ʾδ��ǩ
     *                 taskNode.setAddSign(0);
     *             }
     *             //�޸�˵��
     *             taskNode.setComment(taskLog.getReason());
     *             taskNode.setTaskId(Optional.ofNullable(taskLog.getId()).orElse(0L));
     *             taskNode.setNextTaskId(Optional.ofNullable(taskLog.getNextTask()).orElse(0L));
     *             // �ڵ�״̬ -2�������� -1 �Ѳ��� 0 ������ 1 ��ͨ�� 2 ������ 3�ύ����
     *             Integer status = taskLog.getStatus();
     *             if (status == 0) {
     *                 //�����һ�������ˣ���ǰδ���������ھ���������  ������һ�����ύ����
     *                 if (lastStatus == 1 || lastStatus == 3) {
     *                     taskNode.setStatus(2);
     *                     taskNode.setActive(true);
     *                     lastStatus = 0;
     *                 }
     *             } else {
     *                 taskNode.setStatus(status);
     *             }
     *             String assignUser = taskLog.getAuditAssignReq();
     *             // ���񱻴��������ȡ��ʵ�����ˣ�����ʱ����������������
     *             if (status != 0) {
     *                 assignUser = taskLog.getAuditAssign();
     *                 if (status == -2) {
     *                     assignUser = processLog.getApplyUser();
     *                 }
     *                 lastStatus = status;
     *             }
     *             if (taskLog.getAuditEndTime() != null) {
     *                 taskNode.setModifyTime(CommonUtil.dateToYMDHMSString(taskLog.getAuditEndTime()));
     *             } else {
     *                 taskNode.setModifyTime(CommonUtil.dateToYMDHMSString(taskLog.getAuditStartTime()));
     *             }
     *             taskNode.setTaskKey(taskNode.getTaskKey());
     *             if (StringUtils.isNotEmpty(assignUser)) {
     *                 String[] ids = assignUser.split(",");
     *                 List<FlowDetail.AssignerInfo> assignerInfos = new ArrayList<>();
     *                 for (String misid : ids) {
     *                     DimEmployeeBean employeeBean = superiorMap.get(misid);
     *                     if (employeeBean != null) {
     *                         FlowDetail.AssignerInfo assignerInfo = new FlowDetail.AssignerInfo();
     *                         assignerInfo.setAuditMis(misid);
     *                         assignerInfo.setAuditName(employeeBean.getEmployeeName());
     *                         assignerInfo.setAvatarUrl(userAvatarUrl.get(misid));
     *                         assignerInfos.add(assignerInfo);
     *                     }
     *                 }
     *                 taskNode.setAssigners(assignerInfos);
     *             }
     *             result.add(taskNode);
     *             //���ػ�����һ���Ͳ�������
     *             if (status == -1 || status == -2) {
     *                 break;
     *             }
     *         }
     *
     *         return result;
     *     }
     */


    /**
     *  ��΢�ع���һ�£����ǲ��ã�forѭ���޸���ʱ����
     * private List<FlowDetail.TaskNode> getFlowTask(AuditFlowProcessLog processLog) {
     *         String processId = String.valueOf(processLog.getProcessId());
     *         //task�������ˣ�δͨ���� ����ͨ���Ĳ�ͬ
     *         List<TaskLogExtend> auditFlowTaskLogs = getTask(processId);
     *         // ��������ڵ������漰������Ա�����������˺ͽڵ������ˣ�
     *         List<String> userMisIds = auditFlowTaskLogs.stream().map(t -> {
     *             List<String> taskAssignerList = new ArrayList<>();
     *             if (StringUtils.isNotBlank(t.getAuditAssignReq())) {
     *                 taskAssignerList.addAll(Arrays.asList(t.getAuditAssignReq().split(",")));
     *             }
     *             if (StringUtils.isNotBlank(t.getAuditAssign())) {
     *                 taskAssignerList.addAll(Arrays.asList(t.getAuditAssign().split(",")));
     *             }
     *             return taskAssignerList;
     *         }).flatMap(t -> t.stream()).distinct().collect(toList());
     *         userMisIds.add(processLog.getApplyUser());
     *         List<DimEmployeeBean> empInfoList = dimEmployeeService.getEmpInfoListByMisListContainsLeave(userMisIds);
     *         Map<String, DimEmployeeBean> superiorMap = empInfoList.stream().collect(Collectors.toMap(DimEmployeeBean::getMisName, dimEmployeeBean -> dimEmployeeBean));
     *
     *         List<FlowDetail.TaskNode> result = new ArrayList<>();
     *         Map<String, String> userAvatarUrl = rpcCommonQueryService.getUserAvatarUrlList(userMisIds);
     *         //��һ�����ύ����
     *         result.add(getApplyNode(processLog, auditFlowTaskLogs, superiorMap, userAvatarUrl));
     *         result.addAll(getResult(auditFlowTaskLogs, superiorMap, userAvatarUrl));
     *         return result;
     *     }
     *
     *     private FlowDetail.TaskNode getApplyNode(AuditFlowProcessLog processLog, List<TaskLogExtend> auditFlowTaskLogs, Map<String, DimEmployeeBean> superiorMap, Map<String, String> userAvatarUrl) {
     *         FlowDetail.TaskNode.TaskNodeBuilder builder = FlowDetail.TaskNode.builder();
     *         builder.status(3)
     *         .modifyTime(CommonUtil.dateToYMDHMSString(auditFlowTaskLogs.get(0).getAuditStartTime()));
     *         List<FlowDetail.AssignerInfo> applyInfo = new ArrayList<>();
     *         DimEmployeeBean applyEmployee = superiorMap.get(processLog.getApplyUser());
     *         if (applyEmployee != null) {
     *             FlowDetail.AssignerInfo applyAssignerInfo = new FlowDetail.AssignerInfo();
     *             applyAssignerInfo.setAuditMis(processLog.getApplyUser());
     *             applyAssignerInfo.setAuditName(applyEmployee.getEmployeeName());
     *             applyAssignerInfo.setAvatarUrl(userAvatarUrl.get(processLog.getApplyUser()));
     *             applyInfo.add(applyAssignerInfo);
     *         }
     *         builder.assigners(applyInfo);
     *         return builder.build();
     *     }
     *
     *     private List<FlowDetail.TaskNode> getResult(List<TaskLogExtend> auditFlowTaskLogs, Map<String, DimEmployeeBean> superiorMap, Map<String, String> userAvatarUrl) {
     *         List<FlowDetail.TaskNode> result = new ArrayList<>();
     *         final int APPLY_STATUS = 3;
     *         final int IN_APPROVING_STATUS = 2;
     *         final int APPROVED_STATUS = 1;
     *         final int WAIT_APPROVE_STATUS = 0;
     *         final int REJECTED_STATUS = -1;
     *         final int CANCEL_STATUS = -2;
     *         int lastStatus = APPLY_STATUS;
     *         for (TaskLogExtend taskLog : auditFlowTaskLogs) {
     *             FlowDetail.TaskNode.TaskNodeBuilder builder = FlowDetail.TaskNode.builder();
     *             //1��ǩ����
     *             builder.addSign(taskLog.getAddSign()).addSignComment(taskLog.getAddComment());
     *             //�޸�˵��
     *             builder.comment(taskLog.getReason())
     *                     .taskId(Optional.ofNullable(taskLog.getId()).orElse(0L))
     *                     .nextTaskId(Optional.ofNullable(taskLog.getNextTask()).orElse(0L));
     *
     *             // �ڵ�״̬ -2�������� -1 �Ѳ��� 0 ������ 1 ��ͨ�� 2 ������ 3�ύ����
     *             int status = taskLog.getStatus();
     *             todo ֱ��ʹ�� taskLog�� active�ֶξ����ˣ��Ϳ��Բ��� status�����
     *             if (status == WAIT_APPROVE_STATUS && (lastStatus == APPROVED_STATUS || lastStatus == APPLY_STATUS)) {
     *                 //�����һ�������ˣ���ǰδ���������ھ���������  ������һ�����ύ����
     *                 builder.status(IN_APPROVING_STATUS).active(true);
     *             } else {
     *                 builder.status(status);
     *             }
     *             lastStatus = status;
     *
     *             if (taskLog.getAuditEndTime() != null) {
     *                 builder.modifyTime(CommonUtil.dateToYMDHMSString(taskLog.getAuditEndTime()));
     *             } else {
     *                 builder.modifyTime(CommonUtil.dateToYMDHMSString(taskLog.getAuditStartTime()));
     *             }
     *
     *             String assignUser = StringUtils.isEmpty(taskLog.getAuditAssign()) ? taskLog.getAuditAssignReq() : taskLog.getAuditAssign();
     *             builder.assigners(getAssignInfo(superiorMap, userAvatarUrl, assignUser));
     *             result.add(builder.build());
     *             //���ػ�����һ���Ͳ�������
     *             if (status == REJECTED_STATUS || status == CANCEL_STATUS) {
     *                 break;
     *             }
     *         }
     *         return result;
     *     }
     *
     *     private List<FlowDetail.AssignerInfo> getAssignInfo(Map<String, DimEmployeeBean> superiorMap, Map<String, String> userAvatarUrl, String assignUser) {
     *         if(StringUtils.isEmpty(assignUser)){
     *             return Collections.emptyList();
     *         }
     *         String[] ids = assignUser.split(",");
     *         List<FlowDetail.AssignerInfo> assignerInfos = new ArrayList<>();
     *         for (String misid : ids) {
     *             DimEmployeeBean employeeBean = superiorMap.get(misid);
     *             if (employeeBean != null) {
     *                 FlowDetail.AssignerInfo assignerInfo = new FlowDetail.AssignerInfo();
     *                 assignerInfo.setAuditMis(misid);
     *                 assignerInfo.setAuditName(employeeBean.getEmployeeName());
     *                 assignerInfo.setAvatarUrl(userAvatarUrl.get(misid));
     *                 assignerInfos.add(assignerInfo);
     *             }
     *         }
     *         return assignerInfos;
     *     }
     */
}
