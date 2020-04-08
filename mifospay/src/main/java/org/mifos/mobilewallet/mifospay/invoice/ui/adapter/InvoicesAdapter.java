package org.mifos.mobilewallet.mifospay.invoice.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.mifos.mobilewallet.core.data.fineract.entity.Invoice;
import org.mifos.mobilewallet.core.utils.DateHelper;
import org.mifos.mobilewallet.mifospay.R;
import org.mifos.mobilewallet.mifospay.utils.Constants;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ankur on 11/June/2018
 */

public class InvoicesAdapter
        extends RecyclerView.Adapter<InvoicesAdapter.ViewHolder> {

    private Context context;
    private List<Invoice> mInvoiceList;

    @Inject
    public InvoicesAdapter() {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_invoice, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Invoice invoice = mInvoiceList.get(position);

        holder.mTvInvoiceId.setText("Invoice Id: " + invoice.getId() + "");
        holder.mTvInvoiceStatus.setText(
                (invoice.getStatus() == 0) ? Constants.PENDING : Constants.DONE);
        holder.mTvInvoiceDate.setText(DateHelper.getDateAsString(invoice.getDate()));
        holder.mTvInvoiceAmount.setText(Constants.INR + invoice.getAmount());
    }

    @Override
    public int getItemCount() {
        if (mInvoiceList != null) {
            return mInvoiceList.size();
        } else {
            return 0;
        }
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setData(List<Invoice> invoices) {
        this.mInvoiceList = invoices;
        notifyDataSetChanged();
    }

    public List<Invoice> getInvoiceList() {
        return mInvoiceList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_invoice_id)
        TextView mTvInvoiceId;
        @BindView(R.id.tv_invoice_date)
        TextView mTvInvoiceDate;
        @BindView(R.id.tv_invoice_status)
        TextView mTvInvoiceStatus;
        @BindView(R.id.tv_invoice_amount)
        TextView mTvInvoiceAmount;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}


