
    create table pm$t_performance_report (
       id int8 not null,
        ip varchar(255),
        version int8,
        create_by_id int8 not null,
        create_date timestamp not null,
        priority int4,
        row_level_id int4,
        state varchar(255),
        update_by_id int8,
        update_date timestamp,
        report TEXT,
        project_id int8,
        primary key (id)
    );

    create table pm$t_project (
       id int8 not null,
        ip varchar(255),
        version int8,
        create_by_id int8 not null,
        create_date timestamp not null,
        priority int4,
        row_level_id int4,
        state varchar(255),
        update_by_id int8,
        update_date timestamp,
        budget float8,
        end_date TIMESTAMP,
        project_type varchar(255),
        start_date TIMESTAMP,
        title varchar(255),
        primary key (id)
    );

    create table pm$t_project_attachment (
       id int8 not null,
        ip varchar(255),
        version int8,
        create_by_id int8 not null,
        create_date timestamp not null,
        priority int4,
        row_level_id int4,
        state varchar(255),
        update_by_id int8,
        update_date timestamp,
        attachment_type varchar(255),
        project_id int8,
        primary key (id)
    );

    create table pm$t_project_member (
       id int8 not null,
        ip varchar(255),
        version int8,
        create_by_id int8 not null,
        create_date timestamp not null,
        priority int4,
        row_level_id int4,
        state varchar(255),
        update_by_id int8,
        update_date timestamp,
        end_date TIMESTAMP,
        start_date TIMESTAMP,
        project_id int8,
        primary key (id)
    );

    create table pm$t_project_setting (
       id int8 not null,
        ip varchar(255),
        version int8,
        create_by_id int8 not null,
        create_date timestamp not null,
        priority int4,
        row_level_id int4,
        state varchar(255),
        update_by_id int8,
        update_date timestamp,
        performance_report_period int4,
        project_id int8,
        primary key (id)
    );

    create table pm$t_wbs (
       id int8 not null,
        ip varchar(255),
        version int8,
        create_by_id int8 not null,
        create_date timestamp not null,
        priority int4,
        row_level_id int4,
        state varchar(255),
        update_by_id int8,
        update_date timestamp,
        actual_end_date TIMESTAMP,
        actual_start_date TIMESTAMP,
        rpogress_percent int4,
        scheduled_end_date TIMESTAMP,
        scheduled_start_date TIMESTAMP,
        title varchar(255),
        weight_percent int4,
        project_id int8,
        primary key (id)
    );

    create table pm$t_wbs_progress_report (
       id int8 not null,
        ip varchar(255),
        version int8,
        create_by_id int8 not null,
        create_date timestamp not null,
        priority int4,
        row_level_id int4,
        state varchar(255),
        update_by_id int8,
        update_date timestamp,
        progress_percent int4,
        performance_report_id int8,
        wbs_id int8,
        primary key (id)
    );

    alter table pm$t_performance_report 
       add constraint PERFORMANCE_REPORT_PROJECT_FK_ID 
       foreign key (project_id) 
       references pm$t_project;

    alter table pm$t_project_attachment 
       add constraint P_ATTACHMENT_PROJECT_FK_ID 
       foreign key (project_id) 
       references pm$t_project;

    alter table pm$t_project_member 
       add constraint P_MEMBER_PROJECT_FK_ID 
       foreign key (project_id) 
       references pm$t_project;

    alter table pm$t_project_setting 
       add constraint P_SETTING_PROJECT_FK_ID 
       foreign key (project_id) 
       references pm$t_project;

    alter table pm$t_wbs 
       add constraint WBS_PROJECT_FK_ID 
       foreign key (project_id) 
       references pm$t_project;

    alter table pm$t_wbs_progress_report 
       add constraint WBS_PROGRESS_REPORT_PERFORMANCE_REPORT_FK_ID 
       foreign key (performance_report_id) 
       references pm$t_performance_report;

    alter table pm$t_wbs_progress_report 
       add constraint W_PROGRESS_REPORT_WBS_FK_ID 
       foreign key (wbs_id) 
       references pm$t_wbs;

    create table pm$t_performance_report (
       id int8 not null,
        ip varchar(255),
        version int8,
        create_by_id int8 not null,
        create_date timestamp not null,
        priority int4,
        row_level_id int4,
        state varchar(255),
        update_by_id int8,
        update_date timestamp,
        report TEXT,
        project_id int8,
        primary key (id)
    );

    create table pm$t_project (
       id int8 not null,
        ip varchar(255),
        version int8,
        create_by_id int8 not null,
        create_date timestamp not null,
        priority int4,
        row_level_id int4,
        state varchar(255),
        update_by_id int8,
        update_date timestamp,
        budget float8,
        end_date TIMESTAMP,
        project_type varchar(255),
        start_date TIMESTAMP,
        title varchar(255),
        primary key (id)
    );

    create table pm$t_project_attachment (
       id int8 not null,
        ip varchar(255),
        version int8,
        create_by_id int8 not null,
        create_date timestamp not null,
        priority int4,
        row_level_id int4,
        state varchar(255),
        update_by_id int8,
        update_date timestamp,
        attachment_type varchar(255),
        project_id int8,
        primary key (id)
    );

    create table pm$t_project_member (
       id int8 not null,
        ip varchar(255),
        version int8,
        create_by_id int8 not null,
        create_date timestamp not null,
        priority int4,
        row_level_id int4,
        state varchar(255),
        update_by_id int8,
        update_date timestamp,
        end_date TIMESTAMP,
        start_date TIMESTAMP,
        project_id int8,
        primary key (id)
    );

    create table pm$t_project_setting (
       id int8 not null,
        ip varchar(255),
        version int8,
        create_by_id int8 not null,
        create_date timestamp not null,
        priority int4,
        row_level_id int4,
        state varchar(255),
        update_by_id int8,
        update_date timestamp,
        performance_report_period int4,
        project_id int8,
        primary key (id)
    );

    create table pm$t_wbs (
       id int8 not null,
        ip varchar(255),
        version int8,
        create_by_id int8 not null,
        create_date timestamp not null,
        priority int4,
        row_level_id int4,
        state varchar(255),
        update_by_id int8,
        update_date timestamp,
        actual_end_date TIMESTAMP,
        actual_start_date TIMESTAMP,
        rpogress_percent int4,
        scheduled_end_date TIMESTAMP,
        scheduled_start_date TIMESTAMP,
        title varchar(255),
        weight_percent int4,
        project_id int8,
        primary key (id)
    );

    create table pm$t_wbs_progress_report (
       id int8 not null,
        ip varchar(255),
        version int8,
        create_by_id int8 not null,
        create_date timestamp not null,
        priority int4,
        row_level_id int4,
        state varchar(255),
        update_by_id int8,
        update_date timestamp,
        progress_percent int4,
        performance_report_id int8,
        wbs_id int8,
        primary key (id)
    );

    alter table pm$t_performance_report 
       add constraint PERFORMANCE_REPORT_PROJECT_FK_ID 
       foreign key (project_id) 
       references pm$t_project;

    alter table pm$t_project_attachment 
       add constraint P_ATTACHMENT_PROJECT_FK_ID 
       foreign key (project_id) 
       references pm$t_project;

    alter table pm$t_project_member 
       add constraint P_MEMBER_PROJECT_FK_ID 
       foreign key (project_id) 
       references pm$t_project;

    alter table pm$t_project_setting 
       add constraint P_SETTING_PROJECT_FK_ID 
       foreign key (project_id) 
       references pm$t_project;

    alter table pm$t_wbs 
       add constraint WBS_PROJECT_FK_ID 
       foreign key (project_id) 
       references pm$t_project;

    alter table pm$t_wbs_progress_report 
       add constraint WBS_PROGRESS_REPORT_PERFORMANCE_REPORT_FK_ID 
       foreign key (performance_report_id) 
       references pm$t_performance_report;

    alter table pm$t_wbs_progress_report 
       add constraint W_PROGRESS_REPORT_WBS_FK_ID 
       foreign key (wbs_id) 
       references pm$t_wbs;
